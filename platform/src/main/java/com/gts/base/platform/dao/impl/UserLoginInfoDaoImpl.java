package com.gts.base.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.gts.base.platform.dao.UserLoginInfoDao;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.entity.UserLoginInfo;

@Repository
public class UserLoginInfoDaoImpl extends BaseDao implements UserLoginInfoDao {

	@Override
	public int insertUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception {
		int row = this.insert("com.gts.base.platform.userLoginInfo.insertUserLoginInfo", userLoginInfo);
		return row;
	}

	@Override
	public int updateUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception {
		int row = this.update("com.gts.base.platform.userLoginInfo.updateUserLoginInfo", userLoginInfo);
		return row;
	}

	@Override
	public List<UserLoginInfo> listPageUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception {
		List<UserLoginInfo> list = this.queryForList("com.gts.base.platform.userLoginInfo.listPageUserLoginInfo", userLoginInfo);
		return list;
	}

	@Override
	public List<UserLoginInfo> queryUserLoginInfo(UserLoginInfo userLoginInfo) throws Exception {
		List<UserLoginInfo> list = this.queryForList("com.gts.base.platform.userLoginInfo.queryUserLoginInfo", userLoginInfo);
		return list;
	}

	@Override
	public UserLoginInfo getUserLoginInfo(String userLoginInfoId) throws Exception {
		UserLoginInfo userLoginInfo = this.getOne("com.gts.base.platform.userLoginInfo.getUserLoginInfo", userLoginInfoId);
		return userLoginInfo;
	}

}
