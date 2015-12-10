package com.gts.base.platform.test.dao;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.gts.base.platform.dao.LoginInfoDao;
import com.gts.base.platform.dao.entity.LoginInfo;
import com.gts.base.platform.dao.plugin.util.Page;
import com.gts.base.platform.test.BaseTest;

public class LoginInfoTest extends BaseTest {
	
	@Autowired
	private LoginInfoDao loginInfoDao;
	
	@Test
	public void insertLoginInfo(){
		LoginInfo loginInfo = new LoginInfo();
		try {
			loginInfoDao.insertLoginInfo(loginInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getLoginInfoByLoginId(){
		try {
			LoginInfo loginInfo = loginInfoDao.getLoginInfoByLoginId("18811511061");
			System.err.println(loginInfo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listPageLoginInfo(){
		Page page = new Page();
		
		page.setCurrentPage(1);
		page.setShowCount(3);
		
		LoginInfo user = new LoginInfo();
		user.setPage(page);
		try {
			List<LoginInfo> list = loginInfoDao.listPageLoginInfo(user);
			System.err.println(JSON.toJSONString(user.getPage()));
			System.err.println(JSON.toJSONString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
