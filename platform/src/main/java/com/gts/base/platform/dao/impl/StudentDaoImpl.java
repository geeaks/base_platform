package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.StudentDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Student;

@Repository
public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public int insertStudent(Student student) throws Exception {
		int row = this.insert("com.gts.base.platform.student.insertStudent", student);
		return row;
	}

	@Override
	public int updateStudent(Student student) throws Exception {
		int row = this.update("com.gts.base.platform.student.updateStudent", student);
		return row;
	}

	@Override
	public List<Student> listPageStudent(Student student) throws Exception {
		List<Student> list = this.queryForList("com.gts.base.platform.student.listPageStudent", student);
		return list;
	}

	@Override
	public List<Student> queryStudent(Student student) throws Exception {
		List<Student> list = this.queryForList("com.gts.base.platform.student.queryStudent", student);
		return list;
	}

	@Override
	public Student getStudent(String studentId) throws Exception {
		Student student = this.getOne("com.gts.base.platform.student.getStudent", studentId);
		return student;
	}

}
