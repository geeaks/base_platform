package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.LoginLog;

/**
 * @Description: 用户登录日志信息数据访问接口
 * @ClassName: LoginLogDao
 * @author gaoxiang
 * @date 2015年11月25日 下午11:11:18
 */ 
public interface LoginLogDao {
	
	public int insertLoginLog(LoginLog loginLog) throws Exception;
	
	public int updateLoginLog(LoginLog loginLog) throws Exception;
	
	public List<LoginLog> listPageLoginLog(LoginLog loginLog) throws Exception;
	
	public List<LoginLog> queryLoginLog(LoginLog loginLog) throws Exception;
	
	public LoginLog getLoginLog(String loginLogId) throws Exception;
	
}
