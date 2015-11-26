package com.gts.base.platform.controller;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gts.base.platform.utils.IdentifyingCode;
import com.gts.base.platform.utils.enums.EnumSessionKey;

@Controller
public class BaseController {
	
	@RequestMapping(value = "/getImgCode")
	public void genImgCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		HttpSession session = request.getSession();
		session.setAttribute(EnumSessionKey.IMG_CODE_KEY.getKey(), idcodeStr);
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	
	@RequestMapping(value = "/checkImgCode")
	@ResponseBody
	public String checkCode(HttpSession session, String checkCode) throws Exception {
		String idCode = (String) session.getAttribute(EnumSessionKey.IMG_CODE_KEY.getKey());
		if (checkCode != null && !checkCode.trim().equals("")) {
			if (idCode == null) {
				return "验证码过期";
			} else if (!idCode.equalsIgnoreCase(checkCode.trim())) {
				return "请输入正确的验证码";
			} else {
				return "";
			}
		} else {
			return "验证码不可为空";
		}
	}
	
}
