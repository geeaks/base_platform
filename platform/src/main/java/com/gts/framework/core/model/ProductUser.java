package com.gts.framework.core.model;

import java.util.Date;
import com.google.gson.annotations.Expose;

/**
 * @Description: 环境用户封装
 * @ClassName: ProductUser
 * @author gaoxiang
 * @date 2015年11月17日 下午10:49:53
 */ 
public class ProductUser extends GtsBaseModel {
	
	private static final long serialVersionUID = 490559999680222434L;
	
	/** 登录ID */
	@Expose
	private String logonId;
	
	/** 操作员ID，如果是前台操作，则为固定的虚拟操作员ID */
	@Expose
	private String platformId;
	
	/** 用户ID */
	@Expose
	private String userId;
	
	/** 用户昵称 */
	@Expose
	private String nickName;
	
	/** 用户的email地址，只对前台用户有效 */
	@Expose
	private String userEmail;
	
	/** 登录IP地址 */
	@Expose
	private String lastLoginIP;
	
	/** 登录时间 */
	@Expose
	private Date lastLoginDate;
	
	/** 该用户具有的角色 */
	private String[] roles;
	
	public String getLogonId() {
		return logonId;
	}
	
	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}
	
	public String getPlatformId() {
		return platformId;
	}
	
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getLastLoginIP() {
		return lastLoginIP;
	}
	
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}
	
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	public String[] getRoles() {
		return roles;
	}
	
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
}
