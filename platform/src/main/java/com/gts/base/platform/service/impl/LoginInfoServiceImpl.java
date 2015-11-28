package com.gts.base.platform.service.impl;

import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.gts.base.platform.dao.LoginInfoDao;
import com.gts.base.platform.dao.entity.LoginInfo;
import com.gts.base.platform.service.LoginInfoService;
import com.gts.base.platform.service.bo.LoginInfoBo;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {
	
	public static Logger LOGGER = Logger.getLogger(LoginInfoServiceImpl.class);
	
	@Autowired
	private LoginInfoDao loginInfoDao;
	
	@Override
	public int insertLoginInfo(LoginInfo loginInfo) {
		int affectRow = 0;
		try {
			affectRow = loginInfoDao.insertLoginInfo(loginInfo);
		} catch (Exception e) {
			LOGGER.error("保存用户登录信息系统异常", e);
		}
		return affectRow;
	}
	
	@Override
	public int updateLoginInfo(LoginInfo loginInfo) {
		int affectRow = 0;
		try {
			affectRow = loginInfoDao.updateLoginInfo(loginInfo);
		} catch (Exception e) {
			LOGGER.error("修改用户登录信息系统异常", e);
		}
		return affectRow;
	}
	
	@Override
	public List<LoginInfoBo> listPageLoginInfo(LoginInfo loginInfo) {
		List<LoginInfoBo> listBo = Lists.newArrayList();
		try {
			for (LoginInfo loginInfoOrig : loginInfoDao.listPageLoginInfo(loginInfo)) {
				if(loginInfoOrig == null ){
					return listBo;
				}
				LoginInfoBo loginInfoBo = new LoginInfoBo();
				BeanUtils.copyProperties(loginInfoBo, loginInfoOrig);
				listBo.add(loginInfoBo);
			}
		} catch (Exception e) {
			LOGGER.error("分页查询用户登录信息系统异常", e);
		}
		return listBo;
	}
	
	@Override
	public List<LoginInfoBo> queryLoginInfo(LoginInfo loginInfo) {
		List<LoginInfoBo> listBo = Lists.newArrayList();
		try {
			for (LoginInfo loginInfoOrig : loginInfoDao.queryLoginInfo(loginInfo)) {
				if(loginInfoOrig == null ){
					return listBo;
				}
				LoginInfoBo loginInfoBo = new LoginInfoBo();
				BeanUtils.copyProperties(loginInfoBo, loginInfoOrig);
				listBo.add(loginInfoBo);
			}
		} catch (Exception e) {
			LOGGER.error("查询用户登录信息系统异常", e);
		}
		return listBo;
	}
	
	@Override
	public LoginInfoBo getLoginInfo(String id) {
		try {
			LoginInfo loginInfo = loginInfoDao.getLoginInfo(id);
			if(loginInfo == null){
				return null;
			}
			LoginInfoBo loginInfoBo = new LoginInfoBo();
			BeanUtils.copyProperties(loginInfoBo, loginInfo);
			return loginInfoBo;
		} catch (Exception e) {
			LOGGER.error("获取用户登录信息系统异常", e);
		}
		return null;
	}

	@Override
	public LoginInfoBo getLoginInfoByLoginId(String loginId) {
		try {
			LoginInfo loginInfo = loginInfoDao.getLoginInfoByLoginId(loginId);
			if(loginInfo == null){
				return null;
			}
			LoginInfoBo loginInfoBo = new LoginInfoBo();
			BeanUtils.copyProperties(loginInfoBo, loginInfo);
			return loginInfoBo;
		} catch (Exception e) {
			LOGGER.error("获取用户登录信息系统异常", e);
		}
		return null;
	}

	@Override
	public Map<String, Object> verifyLoginPassword(String loginPassword, String password) {
		Map<String, Object> map = Maps.newHashMap();
		if(StringUtils.isBlank(loginPassword) || StringUtils.isBlank(password)){
			map.put("success", false);
			map.put("msg", "入参不可为空");
			return map;
		}
		if(loginPassword.equals(password)){
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("msg", "密码错误");
		}
		return map;
	}
	
}
