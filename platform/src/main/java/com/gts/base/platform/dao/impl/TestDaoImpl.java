package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.TestDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.Test_table;

@Repository
public class TestDaoImpl extends BaseDao implements TestDao {

	public int insertTest(Test_table test) throws Exception {
		int row = this.insert("com.gts.base.platform.insertTest", test);
		return row;
	}

	public List<Test_table> listPageTest(Test_table test) throws Exception {
		List<Test_table> list = this.queryForList("com.gts.base.platform.listPageTest", test);
		return list;
	}

}
