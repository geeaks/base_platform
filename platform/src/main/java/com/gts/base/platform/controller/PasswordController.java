package com.gts.base.platform.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gts.base.platform.controller.base.BaseController;
import com.gts.base.platform.service.LoginInfoService;
import com.gts.base.platform.service.NoteService;
import com.gts.base.platform.service.NoticeService;
import com.gts.base.platform.service.PendingItemService;
import com.gts.base.platform.service.UserService;

/**
 * @Description:密码操作控制器
 * @ClassName: PasswordController
 * @author gaoxiang
 * @date 2015年11月29日 下午10:12:17
 */ 
@Controller
@RequestMapping("/password")
public class PasswordController extends BaseController {
	
	public static Logger LOGGER = Logger.getLogger(PasswordController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginInfoService loginInfoService;
	
	@RequestMapping("/forgetPwd")
	public String forgetPwd(HttpSession session,Model model){
		return "login/forgetPwd";
	}
	
	@RequestMapping("/modifyLoginPwd")
	public String modifyLoginPwd(HttpSession session,Model model){
		return "home/index";
	}
	
}
