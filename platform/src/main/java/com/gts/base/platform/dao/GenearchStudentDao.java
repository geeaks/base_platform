package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.GenearchStudent;

public interface GenearchStudentDao {
	
	public int insertGenearchStudent(GenearchStudent genearchStudent) throws Exception;
	
	public int updateGenearchStudent(GenearchStudent genearchStudent) throws Exception;
	
	public List<GenearchStudent> listPageGenearchStudent(GenearchStudent genearchStudent) throws Exception;
	
	public List<GenearchStudent> queryGenearchStudent(GenearchStudent genearchStudent) throws Exception;
	
	public GenearchStudent getGenearchStudent(String id) throws Exception;
	
}
