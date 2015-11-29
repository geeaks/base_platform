package com.gts.base.platform.service.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import com.gts.base.platform.dao.LoginLogDao;
import com.gts.base.platform.dao.entity.LoginLog;
import com.gts.base.platform.service.LoginLogService;
import com.gts.base.platform.service.base.BaseService;
import com.gts.base.platform.service.bo.LoginLogBo;
import com.gts.framework.log.annotation.DigestLogAnnotated;
import com.gts.framework.log.enums.LoggerLevel;

@Service
public class LoginLogServiceImpl extends BaseService implements LoginLogService {
	
	public static Logger LOGGER = Logger.getLogger(LoginLogServiceImpl.class);
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public int insertLoginLog(LoginLog loginLog) {
		int affectRow = 0;
		try {
			affectRow = loginLogDao.insertLoginLog(loginLog);
		} catch (Exception e) {
			LOGGER.error("保存登录日志系统异常", e);
		}
		return affectRow;
	}
	
	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public List<LoginLogBo> listPageLoginLog(LoginLog loginLog) {
		List<LoginLogBo> listBo = Lists.newArrayList();
		try {
			for (LoginLog loginLogOrig : loginLogDao.listPageLoginLog(loginLog)) {
				LoginLogBo loginLogBo = new LoginLogBo();
				BeanUtils.copyProperties(loginLogOrig, loginLogBo);
				listBo.add(loginLogBo);
			}
		} catch (Exception e) {
			LOGGER.error("分页查询登录日志系统异常", e);
		}
		return listBo;
	}
	
	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public List<LoginLogBo> queryLoginLog(LoginLog loginLog) {
		List<LoginLogBo> listBo = Lists.newArrayList();
		try {
			for (LoginLog loginLogOrig : loginLogDao.queryLoginLog(loginLog)) {
				LoginLogBo loginLogBo = new LoginLogBo();
				BeanUtils.copyProperties(loginLogOrig, loginLogBo);
				listBo.add(loginLogBo);
			}
		} catch (Exception e) {
			LOGGER.error("查询登录日志系统异常", e);
		}
		return listBo;
	}
	
	@Override
	@DigestLogAnnotated(digestIdentificationCode = "gts", logFileName = "DEFAULT.DIG", loggerLevel = LoggerLevel.INFO)
	public LoginLogBo getLoginLog(String id) {
		try {
			LoginLog loginLog = loginLogDao.getLoginLog(id);
			LoginLogBo loginLogBo = new LoginLogBo();
			BeanUtils.copyProperties(loginLog, loginLogBo);
			return loginLogBo;
		} catch (Exception e) {
			LOGGER.error("获取登录日志系统异常", e);
		}
		return null;
	}

	@Override
	public void recordLoginLog(Integer userId, String clientIP, String clinetPlace) {
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(userId);
		loginLog.setLoginTime(new Date());
		loginLog.setLoginIP(clientIP);
		loginLog.setLoginPlace(clinetPlace);
		this.insertLoginLog(loginLog);
	}
	
}
