package com.gts.base.platform.controller;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.gts.base.platform.utils.IdentifyingCode;
import com.gts.base.platform.utils.enums.EnumSessionKey;

@Controller
public class LoginController extends BaseController {
	
	public static Logger LOGGER = Logger.getLogger(LoginController.class);
	
	@RequestMapping("")
	public String index(Model model){
		
		return "index";
	}
	
	@RequestMapping("/login")
	public @ResponseBody Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, Model model){
		Map<String, Object> map = new HashMap<String,Object>();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
			map.put("success", false);
			map.put("msg", "登录名或密码输入错误");
			return map;
		}
		map.put("success", true);
		map.put("msg", "登录成功，登录名:【"+userName+"】 登录密码:【"+password+"】");
		return map;
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
		Map<String,Object> map = Maps.newHashMap();
		String idCode = (String) session.getAttribute(EnumSessionKey.IMG_CODE_KEY.getKey());
		if (StringUtils.isNotBlank(checkCode)) {
			if (idCode == null) {
				map.put("success", false);
				map.put("msg","验证码过期");
			} else if (!idCode.equalsIgnoreCase(checkCode.trim())) {
				map.put("success", false);
				map.put("msg","请输入正确的验证码");
			} else {
				map.put("success", true);
				map.put("msg","输入正确");
			}
		} else {
			map.put("success", true);
			map.put("msg","验证码不可为空");
		}
		return map;
	}
	
}
