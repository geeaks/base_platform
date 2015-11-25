package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 家长信息 实体
 * @ClassName: Genearch
 * @author gaoxiang
 * @date 2015年11月24日 下午11:53:56
 */
public class Genearch extends BaseEntity {
	
	/**
	 * @Fields generachId : 家长ID
	 */
	private Integer generachId;
	
	/**
	 * @Fields userId : 用户ID
	 */
	private Integer userId;
	
	public Integer getGenerachId() {
		return generachId;
	}
	
	public void setGenerachId(Integer generachId) {
		this.generachId = generachId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
