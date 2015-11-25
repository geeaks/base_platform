package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.User;

/**
 * @Description: 用户信息数据访问接口
 * @ClassName: UserDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:43
 */ 
public interface UserDao {
	
	public int insertUser(User user) throws Exception;
	
	public int updateUser(User user) throws Exception;
	
	public List<User> listPageUser(User user) throws Exception;
	
	public List<User> queryUser(User user) throws Exception;
	
	public User getUser(String userId) throws Exception;
	
}
