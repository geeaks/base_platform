package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.LoginInfoDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.LoginInfo;

@Repository
public class LoginInfoDaoImpl extends BaseDao implements LoginInfoDao {

	@Override
	public int insertLoginInfo(LoginInfo loginInfo) throws Exception {
		int row = this.insert("com.gts.base.platform.loginInfo.insertUserLoginInfo", loginInfo);
		return row;
	}

	@Override
	public int updateLoginInfo(LoginInfo loginInfo) throws Exception {
		int row = this.update("com.gts.base.platform.loginInfo.updateUserLoginInfo", loginInfo);
		return row;
	}

	@Override
	public List<LoginInfo> listPageLoginInfo(LoginInfo loginInfo) throws Exception {
		List<LoginInfo> list = this.queryForList("com.gts.base.platform.loginInfo.listPageUserLoginInfo", loginInfo);
		return list;
	}

	@Override
	public List<LoginInfo> queryLoginInfo(LoginInfo loginInfo) throws Exception {
		List<LoginInfo> list = this.queryForList("com.gts.base.platform.loginInfo.queryUserLoginInfo", loginInfo);
		return list;
	}

	@Override
	public LoginInfo getLoginInfo(String loginInfoId) throws Exception {
		LoginInfo loginInfo = this.getOne("com.gts.base.platform.loginInfo.getUserLoginInfo", loginInfoId);
		return loginInfo;
	}

	@Override
	public LoginInfo getLoginInfoByLoginId(String loginId) throws Exception {
		LoginInfo loginInfo = this.getOne("com.gts.base.platform.loginInfo.getUserLoginInfo", loginId);
		return loginInfo;
	}

}
