package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.UserLoginInfo;

/**
 * @Description: 用户信息数据访问接口
 * @ClassName: UserLoginInfoDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:53
 */ 
public interface UserLoginInfoDao {
	
	public int insertUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception;
	
	public int updateUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception;
	
	public List<UserLoginInfo> listPageUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception;
	
	public List<UserLoginInfo> queryUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception;
	
	public UserLoginInfo getUserLoginInfo(String id) throws Exception;
	
}
