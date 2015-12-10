package com.gts.base.platform.test.dao;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.gts.base.platform.dao.UserDao;
import com.gts.base.platform.dao.entity.User;
import com.gts.base.platform.dao.plugin.util.Page;
import com.gts.base.platform.test.BaseTest;

public class UserDaoTest extends BaseTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	
	public void insertUser(){
		User user = new User();
		user.setUserId(1);
		try {
			int rows = userDao.insertUser(user);
			System.err.println(user.getUserId());
			System.err.println(rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	@Test
	public void listPageUser(){
		Page page = new Page();
		
		page.setCurrentPage(1);
		page.setShowCount(3);
		
		User user = new User();
		user.setPage(page);
		try {
			List<User> list = userDao.listPageUser(user);
			System.err.println(JSON.toJSONString(user.getPage()));
			System.err.println(JSON.toJSONString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
