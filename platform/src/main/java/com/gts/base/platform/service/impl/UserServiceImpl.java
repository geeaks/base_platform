package com.gts.base.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gts.base.platform.dao.UserDao;
import com.gts.base.platform.dao.entity.User;
import com.gts.base.platform.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int insertUser(User user) throws Exception {
		return userDao.insertUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> listPageUser(User user) throws Exception {
		List<User> list = userDao.listPageUser(user);
		return list;
	}

	@Override
	public List<User> queryUser(User user) throws Exception {
		List<User> list = userDao.queryUser(user);
		return list;
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userDao.getUser(userId);
	}

}
