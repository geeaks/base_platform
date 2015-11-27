package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.LoginInfo;

/**
 * @Description: 用户信息数据访问接口
 * @ClassName: LoginInfoDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:12:53
 */ 
public interface LoginInfoDao {
	
	public int insertLoginInfo(LoginInfo loginInfo) throws Exception;
	
	public int updateLoginInfo(LoginInfo loginInfo) throws Exception;
	
	public List<LoginInfo> listPageLoginInfo(LoginInfo loginInfo) throws Exception;
	
	public List<LoginInfo> queryLoginInfo(LoginInfo loginInfo) throws Exception;
	
	public LoginInfo getLoginInfo(String id) throws Exception;

	public LoginInfo getLoginInfoByLoginId(String loginId) throws Exception;
	
}
