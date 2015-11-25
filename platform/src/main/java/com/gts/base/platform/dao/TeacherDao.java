package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Teacher;

public interface TeacherDao {
	
	public int insertTeacher(Teacher teacher) throws Exception;
	
	public int updateTeacher(Teacher teacher) throws Exception;
	
	public List<Teacher> listPageTeacher(Teacher teacher) throws Exception;
	
	public List<Teacher> queryTeacher(Teacher teacher) throws Exception;
	
	public Teacher getTeacher(String teacherId) throws Exception;
	
}
