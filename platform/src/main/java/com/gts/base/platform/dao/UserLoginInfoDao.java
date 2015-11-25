package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.UserLoginInfo;

public interface UserLoginInfoDao {
	
	public int insertUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception;
	
	public int updateUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception;
	
	public List<UserLoginInfo> listPageUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception;
	
	public List<UserLoginInfo> queryUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception;
	
	public UserLoginInfo getUserLoginInfo(String id) throws Exception;
	
}
