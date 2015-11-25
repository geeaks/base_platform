package com.gts.base.platform.dao.entity;

import java.util.Date;
import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 用户登录信息实体
 * @ClassName: UserLoginInfo
 * @author gaoxiang
 * @date 2015年11月24日 下午11:00:24
 */
public class UserLoginInfo extends BaseEntity {
	
	private String id;
	
	/**
	 * @Fields loginId : 登录名
	 */
	private String loginId;
	
	/**
	 * @Fields userId : 用户ID
	 */
	private String userId;
	
	/**
	 * @Fields loginType : 登录类型
	 */
	private String loginType;
	
	/**
	 * @Fields loginPassword : 登录密码
	 */
	private String loginPassword;
	
	/**
	 * @Fields userType : 用户类型
	 */
	private String userType;
	
	/**
	 * @Fields lastLoginType : 最后登录时间
	 */
	private Date lastLoginTime;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getLoginType() {
		return loginType;
	}
	
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	public String getLoginPassword() {
		return loginPassword;
	}
	
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
}
