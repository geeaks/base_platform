package com.gts.base.platform.service;

import java.util.List;
import java.util.Map;
import com.gts.base.platform.dao.entity.LoginInfo;
import com.gts.base.platform.service.bo.LoginInfoBo;

public interface LoginInfoService {
	
	public int insertLoginInfo(LoginInfo loginInfoBo);
	
	public int updateLoginInfo(LoginInfo loginInfoBo);
	
	public List<LoginInfoBo> listPageLoginInfo(LoginInfo userLoginInfo);
	
	public List<LoginInfoBo> queryLoginInfo(LoginInfo userLoginInfo);
	
	public LoginInfoBo getLoginInfo(String id);
	
	public LoginInfoBo getLoginInfoByLoginId(String loginId);
	
	public Map<String,Object> verifyLoginPassword(String loginPassword, String password);
	
}
