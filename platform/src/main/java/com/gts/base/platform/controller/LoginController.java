package com.gts.base.platform.controller;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gts.base.platform.controller.base.BaseController;
import com.gts.base.platform.service.LoginInfoService;
import com.gts.base.platform.service.LoginLogService;
import com.gts.base.platform.service.bo.LoginInfoBo;
import com.gts.base.platform.service.bo.UserBo;
import com.gts.base.platform.utils.IdentifyingCode;
import com.gts.base.platform.utils.enums.EnumSessionKey;
import com.gts.framework.core.util.AddressUtils;
import com.gts.framework.web.util.HttpHeaderUtils;

/**
 * @Description: 登录控制器
 * @ClassName: LoginController
 * @author gaoxiang
 * @date 2015年11月30日 下午10:32:07
 */ 
@Controller
public class LoginController extends BaseController {
	
	public static Logger LOGGER = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginInfoService loginInfoService;
	
	@Autowired
	private LoginLogService loginLogService;
	
	@RequestMapping({"","index"})
	public String index(HttpServletRequest request,HttpSession session,Model model){
		//判断用户时否已登录
		UserBo user = super.getUser(session);
		if(user != null){
			model.addAttribute("isLogin",true);
			model.addAttribute("user",user);
		}
		//判断用户是否是登录失效重定向 
		String redirectUrl = getSessionObject(session, EnumSessionKey.REDIRECT_URL.getKey());
		if(StringUtils.isNotBlank(redirectUrl)){
			model.addAttribute("msg","请您登陆");
			session.setAttribute("redirectUrl", redirectUrl);
		}
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(String loginId,String password,String checkCode,HttpSession session,HttpServletRequest request,Model model){
		if(!verifyLogin(loginId,password,checkCode,session,model)){
			return "index";
		}
		//校验成功，记录登录日志
		Integer userId = getLoginInfo(session).getUserId();
		session.setAttribute(EnumSessionKey.USER_KEY.getKey(), userService.getUser(userId));
		String clientIP = HttpHeaderUtils.getClientIP(request);
		loginLogService.recordLoginLog(userId,clientIP,AddressUtils.getIPAddresses(clientIP));
		loginInfoService.recordLastLogin(getLoginInfo(session));
		//重定向到要访问的页面
		String redirectUrl = getSessionObject(session, EnumSessionKey.REDIRECT_URL.getKey());
		if(StringUtils.isNotBlank(redirectUrl)){
			return "redirect:"+redirectUrl;
		}
		session.removeAttribute(EnumSessionKey.REDIRECT_URL.getKey());
		//正常跳转首页
		return "redirect:/home";
	}
	
	/**
	 * @Description: 登录校验
	 * @param userName
	 * @param password
	 * @param checkCode
	 * @return boolean 返回类型
	 * @author gaoxiang
	 * @date 2015年11月28日 上午3:04:25
	 */
	private boolean verifyLogin(String userName, String password, String checkCode,HttpSession session, Model model) {
		//校验登录名和 登录密码
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
			model.addAttribute("success", false);
			model.addAttribute("msg", "登录名或密码输入错误");
			return false;
		}
		//校验 图片验证码
		Map<String, Object> result = verifyCheckCode(session,checkCode);
		if(!(Boolean) result.get("success")){
			model.addAttribute("success", false);
			model.addAttribute("msg", result.get("msg"));
			return false;
		}
		//校验用户是否存在
		LoginInfoBo loginInfo = loginInfoService.getLoginInfoByLoginId(userName);
		session.setAttribute(EnumSessionKey.LOGIN_INFO_KEY.getKey(), loginInfo);
		if(loginInfo == null){
			model.addAttribute("success", false);
			model.addAttribute("msg", "用户不存在");
			return false;
		}
		//校验登录密码是否正确
		Map<String,Object> verifyPwdResult = loginInfoService.verifyLoginPassword(loginInfo.getLoginPassword(),password);
		if(!(Boolean) verifyPwdResult.get("success")){
			model.addAttribute("success", false);
			model.addAttribute("msg", verifyPwdResult.get("msg"));
			return false;
		}
		return true;
	}

	/**
	 * @Description: 登出
	 * @param session
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月27日 下午7:19:05
	 */
	@RequestMapping("/logOut")
	public String logOut(HttpSession session){
		session.invalidate();
		return "index";
	}
	
	/**
	 * @Description: 获取图片验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月27日 下午7:08:14
	 */
	@RequestMapping(value = "/getImgCode")
	public void genImgCode(HttpSession session, HttpServletResponse response) throws IOException {
		// 设置不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的相应图片
		response.setContentType("image/jpeg");
		IdentifyingCode idCode = new IdentifyingCode();
		BufferedImage image = new BufferedImage(idCode.getWidth(), idCode.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D g = image.createGraphics();
		// 定义字体样式
		Font myFont = new Font("黑体", Font.BOLD, 16);
		// 设置字体
		g.setFont(myFont);
		
		g.setColor(idCode.getRandomColor(200, 250));
		// 绘制背景
		g.fillRect(0, 0, idCode.getWidth(), idCode.getHeight());
		
		g.setColor(idCode.getRandomColor(180, 200));
		idCode.drawRandomLines(g, 160);
		String idcodeStr = idCode.drawRandomString(4, g);
		session.setAttribute(EnumSessionKey.IMG_CODE_KEY.getKey(), idcodeStr);
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	
	/**
	 * @Description: 校验图片验证码
	 * @param session
	 * @param checkCode
	 * @throws Exception
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月27日 下午7:08:25
	 */
	@RequestMapping(value = "/checkImgCode")
	public @ResponseBody Map<String,Object> checkCode(HttpSession session, String checkCode) throws Exception {
		return verifyCheckCode(session,checkCode);
	}
	
}
