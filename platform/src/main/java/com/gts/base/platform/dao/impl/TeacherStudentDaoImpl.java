package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.TeacherStudentDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.TeacherStudent;

@Repository
public class TeacherStudentDaoImpl extends BaseDao implements TeacherStudentDao {

	@Override
	public int insertTeacherStudent(TeacherStudent teacherStudent) throws Exception {
		int row = this.insert("com.gts.base.platform.teacherStudent.insertTeacherStudent", teacherStudent);
		return row;
	}

	@Override
	public int updateTeacherStudent(TeacherStudent teacherStudent) throws Exception {
		int row = this.update("com.gts.base.platform.teacherStudent.updateTeacherStudent", teacherStudent);
		return row;
	}

	@Override
	public List<TeacherStudent> listPageTeacherStudent(TeacherStudent teacherStudent) throws Exception {
		List<TeacherStudent> list = this.queryForList("com.gts.base.platform.teacherStudent.listPageTeacherStudent", teacherStudent);
		return list;
	}

	@Override
	public List<TeacherStudent> queryTeacherStudent(TeacherStudent teacherStudent) throws Exception {
		List<TeacherStudent> list = this.queryForList("com.gts.base.platform.teacherStudent.queryTeacherStudent", teacherStudent);
		return list;
	}

}
