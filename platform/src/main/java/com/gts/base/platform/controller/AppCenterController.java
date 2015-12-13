package com.gts.base.platform.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gts.base.platform.controller.base.BaseController;

@Controller
@RequestMapping("/appCenter")
public class AppCenterController extends BaseController {
	
	/**
	 * @Description: 跳转到应用中心页面
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年12月12日 下午6:09:09
	 */
	@RequestMapping("")
	public String index(HttpSession session,Model model){
		return "appCenter/index";
	}
	
}
