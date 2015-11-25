package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.LoginLogDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.LoginLog;

@Repository
public class LoginLogDaoImpl extends BaseDao implements LoginLogDao {

	@Override
	public int insertLoginLog(LoginLog loginLog) throws Exception {
		int row = this.insert("com.gts.base.platform.loginLog.insertLoginLog", loginLog);
		return row;
	}

	@Override
	public int updateLoginLog(LoginLog loginLog) throws Exception {
		int row = this.update("com.gts.base.platform.loginLog.updateLoginLog", loginLog);
		return row;
	}

	@Override
	public List<LoginLog> listPageLoginLog(LoginLog loginLog) throws Exception {
		List<LoginLog> list = this.queryForList("com.gts.base.platform.loginLog.listPageLoginLog", loginLog);
		return list;
	}

	@Override
	public List<LoginLog> queryLoginLog(LoginLog loginLog) throws Exception {
		List<LoginLog> list = this.queryForList("com.gts.base.platform.loginLog.queryLoginLog", loginLog);
		return list;
	}

	@Override
	public LoginLog getLoginLog(String loginLogId) throws Exception {
		LoginLog loginLog = this.getOne("com.gts.base.platform.loginLog.getLoginLog", loginLogId);
		return loginLog;
	}

}
