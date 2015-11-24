package com.gts.base.platform.service.bo;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 家长信息 实体
 * @ClassName: Genearch
 * @author gaoxiang
 * @date 2015年11月24日 下午11:53:56
 */
public class GenearchBo extends BaseEntity {
	
	/**
	 * @Fields generachId : 家长ID
	 */
	private String generachId;
	
	/**
	 * @Fields userId : 用户ID
	 */
	private String userId;
	
	public String getGenerachId() {
		return generachId;
	}
	
	public void setGenerachId(String generachId) {
		this.generachId = generachId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
