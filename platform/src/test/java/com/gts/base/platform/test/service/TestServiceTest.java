package com.gts.base.platform.test.service;

import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.gts.base.platform.dao.entity.Test_table;
import com.gts.base.platform.dao.plugin.Page;
import com.gts.base.platform.service.TestService;
import com.gts.base.platform.test.BaseTest;

public class TestServiceTest extends BaseTest {
	
	@Autowired
	private TestService testService;
	
	@Test
	public void insertTest(){
		Test_table test = new Test_table();
		test.setId(UUID.randomUUID().toString());
		test.setName("SDD");
		try {
			int rows = testService.insertTest(test);
			System.err.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	@Test
	public void listPageTest(){
		Page page = new Page();
		
		page.setCurrentPage(1);
		page.setShowCount(3);
		
		Test_table test = new Test_table();
		test.setName("SDD");
		test.setPage(page);
		try {
			List<Test_table> list = testService.listPageTest(test);
			System.err.println(JSON.toJSONString(test.getPage()));
			System.err.println(JSON.toJSONString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
