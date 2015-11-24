package com.gts.base.platform.service.bo;

import java.util.Date;
import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 登录日志表
 * @ClassName: LoginLog
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class LoginLogBo extends BaseEntity {
	
	/**
	 * @Fields logId : 日志信息 主键
	 */
	private String logId;
	
	/**
	 * @Fields userId : 用户ID
	 */
	private String userId;
	
	/**
	 * @Fields loginTime : 登录时间
	 */
	private Date loginTime;
	
	/**
	 * @Fields loginPlace : 登录地点
	 */
	private String loginPlace;
	
	/**
	 * @Fields loginIP : 登录IP
	 */
	private String loginIP;
	
	public String getLogId() {
		return logId;
	}
	
	public void setLogId(String logId) {
		this.logId = logId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getLoginTime() {
		return loginTime;
	}
	
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	public String getLoginPlace() {
		return loginPlace;
	}
	
	public void setLoginPlace(String loginPlace) {
		this.loginPlace = loginPlace;
	}
	
	public String getLoginIP() {
		return loginIP;
	}
	
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	
}
