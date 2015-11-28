package com.gts.base.platform.service;

import java.util.List;
import com.gts.base.platform.dao.entity.User;
import com.gts.base.platform.service.bo.UserBo;

/**
 * @Description: 用户信息 业务接口
 * @ClassName: UserDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:43
 */ 
public interface UserService {
	
	public int insertUser(User user);
	
	public int updateUser(User user);
	
	public List<UserBo> listPageUser(User user);
	
	public List<UserBo> queryUser(User user);
	
	public UserBo getUser(Integer userId);
	
}
