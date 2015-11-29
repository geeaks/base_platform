package com.gts.base.platform.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gts.base.platform.controller.base.BaseController;
import com.gts.base.platform.service.NoteService;
import com.gts.base.platform.service.NoticeService;
import com.gts.base.platform.service.PendingItemService;

/**
 * @Description:  
 * @ClassName: HomeController
 * @author gaoxiang
 * @date 2015年11月29日 下午10:12:17
 */ 
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
	
	public static Logger LOGGER = Logger.getLogger(HomeController.class);
	
	@Autowired
	private PendingItemService pendingItemService;
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("")
	public String index(HttpSession session,Model model){
		Integer userId = getUser(session).getUserId();
		//获取我的记事信息
		Map<String, Object> noteMap = noteService.listPageNote(userId);
		model.addAttribute("pendingItems", noteMap.get("list"));
		//获取消息中心信息
		Map<String, Object> noticeMap = noticeService.listPageNotice();
		model.addAttribute("pendingItems", noticeMap.get("list"));
		//获取待办事项
		Map<String, Object> pendingItemMap = pendingItemService.listPagePendingItem(userId);
		model.addAttribute("pendingItems", pendingItemMap.get("list"));
		model.addAttribute("page", pendingItemMap.get("page"));
		return "home/index";
	}
	
}
