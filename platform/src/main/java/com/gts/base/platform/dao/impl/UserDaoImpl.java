package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.UserDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.User;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int insertUser(User user) throws Exception {
		int row = this.insert("com.gts.base.platform.user.insertUser", user);
		return row;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int row = this.update("com.gts.base.platform.user.updateUser", user);
		return row;
	}

	@Override
	public List<User> listPageUser(User user) throws Exception {
		List<User> list = this.queryForList("com.gts.base.platform.user.listPageUser", user);
		return list;
	}

	@Override
	public List<User> queryUser(User user) throws Exception {
		List<User> list = this.queryForList("com.gts.base.platform.user.queryUser", user);
		return list;
	}

	@Override
	public User getUser(Integer userId) throws Exception {
		User user = this.getOne("com.gts.base.platform.user.getUser", userId);
		return user;
	}

}
