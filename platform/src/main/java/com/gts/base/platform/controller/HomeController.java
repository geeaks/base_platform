package com.gts.base.platform.controller;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gts.base.platform.controller.base.BaseController;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
	
	public static Logger LOGGER = Logger.getLogger(HomeController.class);
	
	@RequestMapping("")
	public String index(HttpSession session){
		return "home/index";
	}
	
}
