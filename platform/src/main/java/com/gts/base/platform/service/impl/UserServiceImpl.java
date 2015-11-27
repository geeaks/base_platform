package com.gts.base.platform.service.impl;

import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.gts.base.platform.dao.UserDao;
import com.gts.base.platform.dao.entity.User;
import com.gts.base.platform.service.UserService;
import com.gts.base.platform.service.bo.UserBo;

@Service
public class UserServiceImpl implements UserService {
	
	public static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int insertUser(User user) {
		int affectRow = 0;
		try {
			affectRow = userDao.insertUser(user);
		} catch (Exception e) {
			LOGGER.error("保存用户信息系统异常", e);
		}
		return affectRow;
	}

	@Override
	public int updateUser(User user) {
		int affectRow = 0;
		try {
			affectRow = userDao.insertUser(user);
		} catch (Exception e) {
			LOGGER.error("修改用户信息系统异常", e);
		}
		return affectRow;
	}

	@Override
	public List<UserBo> listPageUser(User user) {
		List<UserBo> listBo = Lists.newArrayList();
		try {
			for (User userInfo : userDao.listPageUser(user)) {
				UserBo userBo = new UserBo();
				BeanUtils.copyProperties(userInfo, userBo);
				listBo.add(userBo);
			}
		} catch (Exception e) {
			LOGGER.error("分页查询用户信息系统异常", e);
		}
		return listBo;
	}

	@Override
	public List<UserBo> queryUser(User user) {
		List<UserBo> listBo = Lists.newArrayList();
		try {
			for (User userInfo : userDao.listPageUser(user)) {
				UserBo userBo = new UserBo();
				BeanUtils.copyProperties(userInfo, userBo);
				listBo.add(userBo);
			}
		} catch (Exception e) {
			LOGGER.error("查询用户信息系统异常", e);
		}
		return listBo;
	}

	@Override
	public UserBo getUser(String userId) {
		try {
			User user = userDao.getUser(userId);
			UserBo userBo = new UserBo();
			BeanUtils.copyProperties(user, userBo);
			return userBo;
		} catch (Exception e) {
			LOGGER.error("获取用户信息系统异常", e);
		}
		return null;
	}

}
