package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.TeacherDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Teacher;

@Repository
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	@Override
	public int insertTeacher(Teacher teacher) throws Exception {
		int row = this.insert("com.gts.base.platform.teacher.insertTeacher", teacher);
		return row;
	}

	@Override
	public int updateTeacher(Teacher teacher) throws Exception {
		int row = this.update("com.gts.base.platform.teacher.updateTeacher", teacher);
		return row;
	}

	@Override
	public List<Teacher> listPageTeacher(Teacher teacher) throws Exception {
		List<Teacher> list = this.queryForList("com.gts.base.platform.teacher.listPageTeacher", teacher);
		return list;
	}

	@Override
	public List<Teacher> queryTeacher(Teacher teacher) throws Exception {
		List<Teacher> list = this.queryForList("com.gts.base.platform.teacher.queryTeacher", teacher);
		return list;
	}

	@Override
	public Teacher getTeacher(String teacherId) throws Exception {
		Teacher teacher = this.getOne("com.gts.base.platform.teacher.getTeacher", teacherId);
		return teacher;
	}

}
