package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.Student;
import com.gts.base.platform.service.bo.StudentBo;

/**
 * @Description: 学生信息 业务处理接口
 * @ClassName: StudentService
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:06
 */ 
public interface StudentService {
	
	public int insertStudent(Student student) throws Exception;
	
	public int updateStudent(Student student) throws Exception;
	
	public List<StudentBo> listPageStudent(Student student) throws Exception;
	
	public List<StudentBo> queryStudent(Student student) throws Exception;
	
	public StudentBo getStudent(String studentId) throws Exception;
	
}
