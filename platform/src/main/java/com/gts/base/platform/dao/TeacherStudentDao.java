package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.TeacherStudent;

public interface TeacherStudentDao {
	
	public int insertTeacherStudent(TeacherStudent teacherStudent) throws Exception;
	
	public int updateTeacherStudent(TeacherStudent teacherStudent) throws Exception;
	
	public List<TeacherStudent> listPageTeacherStudent(TeacherStudent teacherStudent) throws Exception;
	
	public List<TeacherStudent> queryTeacherStudent(TeacherStudent teacherStudent) throws Exception;
	
	public TeacherStudent getTeacherStudent(String id) throws Exception;
	
}
