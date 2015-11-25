package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.Student;

/**
 * @Description: 学生信息数据访问接口
 * @ClassName: StudentDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:06
 */ 
public interface StudentDao {
	
	public int insertStudent(Student student) throws Exception;
	
	public int updateStudent(Student student) throws Exception;
	
	public List<Student> listPageStudent(Student student) throws Exception;
	
	public List<Student> queryStudent(Student student) throws Exception;
	
	public Student getStudent(String studentId) throws Exception;
	
}
