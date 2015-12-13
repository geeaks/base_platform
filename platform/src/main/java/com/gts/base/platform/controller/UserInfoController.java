package com.gts.base.platform.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.collect.Maps;
import com.gts.base.platform.controller.base.BaseController;
import com.gts.base.platform.service.GenearchService;
import com.gts.base.platform.service.ManagerService;
import com.gts.base.platform.service.StudentService;
import com.gts.base.platform.service.TeacherService;
import com.gts.base.platform.service.bo.StudentBo;

@RequestMapping("/userInfo")
@Controller
public class UserInfoController extends BaseController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private GenearchService genearchService;
	
	@Autowired
	private ManagerService managerService;
	
	/**
	 * @Description: 跳转到用户信息管理页面
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年12月12日 下午6:09:09
	 */
	@RequestMapping("")
	public String index(HttpSession session,Model model){
		return "userInfo/index";
	}
	
	@RequestMapping("/studentManage")
	public String studentManage(StudentBo studentBo,HttpSession session,Model model){
		studentService.listPageStudent(studentBo);
		return "userInfo/student/index";
	}
	
	@RequestMapping("/studentManage")
	@ResponseBody
	public Map<String,Object> listPageStudent(StudentBo studentBo,HttpSession session,Model model){
		Map<String,Object> map = Maps.newHashMap();
		List<StudentBo> studentList = studentService.listPageStudent(studentBo);
		map.put("studentList", studentList);
		map.put("success", true);
		return map;
	}
	
	@RequestMapping("/genearchManage")
	public String genearchManage(HttpSession session,Model model){
		
		return "userInfo/genearch/index";
	}
	
	@RequestMapping("/teacherManage")
	public String teacherManage(HttpSession session,Model model){
		
		return "userInfo/teacher/index";
	}
	
	@RequestMapping("/operatorManage")
	public String operatorManage(HttpSession session,Model model){
		
		return "userInfo/operator/index";
	}
	
}
