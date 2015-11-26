package com.gts.base.platform.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gts.base.platform.service.CommentService;

@Controller
public class TestController {
	
	public static Logger LOGGER = Logger.getLogger(TestController.class);
	
	@Autowired
	CommentService testService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model){
		return "index";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, Model model){
		Map<String, Object> map = new HashMap<String,Object>();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
			map.put("success", false);
			map.put("msg", "登录名或密码不能为空");
			return map;
		}
		map.put("success", true);
		map.put("msg", "登录成功，登录名:【"+userName+"】 登录密码:【"+password+"】");
		return map;
	}
	
}
