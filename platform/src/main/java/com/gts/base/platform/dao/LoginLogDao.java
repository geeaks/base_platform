package com.gts.base.platform.dao;

import java.util.List;
import com.gts.base.platform.dao.entity.LoginLog;

public interface LoginLogDao {
	
	public int insertLoginLog(LoginLog loginLog) throws Exception;
	
	public int updateLoginLog(LoginLog loginLog) throws Exception;
	
	public List<LoginLog> listPageLoginLog(LoginLog loginLog) throws Exception;
	
	public List<LoginLog> queryLoginLog(LoginLog loginLog) throws Exception;
	
	public LoginLog getLoginLog(String loginLogId) throws Exception;
	
}
