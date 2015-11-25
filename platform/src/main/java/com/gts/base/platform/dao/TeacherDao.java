package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Teacher;

/**
 * @Description: 教师信息数据访问接口
 * @ClassName: TeacherDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:18
 */ 
public interface TeacherDao {
	
	public int insertTeacher(Teacher teacher) throws Exception;
	
	public int updateTeacher(Teacher teacher) throws Exception;
	
	public List<Teacher> listPageTeacher(Teacher teacher) throws Exception;
	
	public List<Teacher> queryTeacher(Teacher teacher) throws Exception;
	
	public Teacher getTeacher(String teacherId) throws Exception;
	
}
