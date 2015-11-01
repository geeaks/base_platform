package com.gts.base.platform.dao;

import java.util.List;

import com.gts.base.platform.dao.entity.Test_table;

public interface TestDao {
	
	public int insertTest(Test_table test) throws Exception;
	
	public List<Test_table> listPageTest(Test_table test) throws Exception;
	
}
