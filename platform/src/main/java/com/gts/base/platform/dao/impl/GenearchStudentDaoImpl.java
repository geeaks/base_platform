package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.GenearchStudentDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.GenearchStudent;

@Repository
public class GenearchStudentDaoImpl extends BaseDao implements GenearchStudentDao {

	@Override
	public int insertGenearchStudent(GenearchStudent genearchStudent) throws Exception {
		int row = this.insert("com.gts.base.platform.genearchStudent.insertGenearchStudent", genearchStudent);
		return row;
	}

	@Override
	public int updateGenearchStudent(GenearchStudent genearchStudent) throws Exception {
		int row = this.update("com.gts.base.platform.genearchStudent.updateGenearchStudent", genearchStudent);
		return row;
	}

	@Override
	public List<GenearchStudent> listPageGenearchStudent(GenearchStudent genearchStudent) throws Exception {
		List<GenearchStudent> list = this.queryForList("com.gts.base.platform.genearchStudent.listPageGenearchStudent", genearchStudent);
		return list;
	}

	@Override
	public List<GenearchStudent> queryGenearchStudent(GenearchStudent genearchStudent) throws Exception {
		List<GenearchStudent> list = this.queryForList("com.gts.base.platform.genearchStudent.queryGenearchStudent", genearchStudent);
		return list;
	}

	@Override
	public GenearchStudent getGenearchStudent(String genearchStudentId) throws Exception {
		GenearchStudent genearchStudent = this.getOne("com.gts.base.platform.genearchStudent.getGenearchStudent", genearchStudentId);
		return genearchStudent;
	}

}
