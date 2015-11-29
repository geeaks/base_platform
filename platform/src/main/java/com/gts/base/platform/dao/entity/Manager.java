package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 管理员信息 实体
 * @ClassName: Manager
 * @author gaoxiang
 * @date 2015年11月24日 下午11:53:56
 */
public class Manager extends BaseEntity {
	
	/**
	 * @Fields managerId : 管理员ID
	 */
	private Integer managerId;
	
	/**
	 * @Fields userId : 用户ID
	 */
	private Integer userId;
	
	public Integer getManagerId() {
		return managerId;
	}
	
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
