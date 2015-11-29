package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.Teacher;
import com.gts.base.platform.service.bo.TeacherBo;

/**
 * @Description: 教师信息 业务处理接口
 * @ClassName: TeacherService
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:18
 */ 
public interface TeacherService {
	
	public int insertTeacher(Teacher teacher) throws Exception;
	
	public int updateTeacher(Teacher teacher) throws Exception;
	
	public List<TeacherBo> listPageTeacher(Teacher teacher) throws Exception;
	
	public List<TeacherBo> queryTeacher(Teacher teacher) throws Exception;
	
	public TeacherBo getTeacher(String teacherId) throws Exception;
	
}
