package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Student;

public interface StudentDao {
	
	public int insertStudent(Student student) throws Exception;
	
	public int updateStudent(Student student) throws Exception;
	
	public List<Student> listPageStudent(Student student) throws Exception;
	
	public List<Student> queryStudent(Student student) throws Exception;
	
	public Student getStudent(String studentId) throws Exception;
	
}
