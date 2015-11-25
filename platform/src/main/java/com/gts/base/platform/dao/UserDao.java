package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.User;

public interface UserDao {
	
	public int insertUser(User user) throws Exception;
	
	public int updateUser(User user) throws Exception;
	
	public List<User> listPageUser(User user) throws Exception;
	
	public List<User> queryUser(User user) throws Exception;
	
	public User getUser(String userId) throws Exception;
	
}
