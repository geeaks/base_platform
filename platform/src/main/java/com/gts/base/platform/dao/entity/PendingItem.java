package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 待办事项 实体
 * @ClassName: PendingItem
 * @author gaoxiang
 * @date 2015年11月24日 下午11:58:51
 */
public class PendingItem extends BaseEntity {
	
	/**
	 * @Fields itemId : 待办事项ID
	 */
	private Integer itemId;
	
	/**
	 * @Fields itemName : 待办事项名称
	 */
	private String itemName;
	
	/**
	 * @Fields itemContent : 待办事项内容
	 */
	private String itemContent;
	
	/**
	 * @Fields itemType : 待办事项类型
	 */ 
	private String itemType;
	
	/**
	 * @Fields handlerStatus : 处理状态
	 */ 
	private String handlerStatus;
	
	/**
	 * @Fields applicantUserId : 请求发起用户ID
	 */ 
	private Integer applicantUserId;
	
	/**
	 * @Fields applicantName : 请求发起人
	 */ 
	private String applicantName;
	
	/**
	 * @Fields handlerUserId : 处理人用户ID
	 */ 
	private Integer handlerUserId;
	
	/**
	 * @Fields handlerName : 处理人
	 */ 
	private String handlerName;
	
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemType() {
		return itemType;
	}
	
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public String getHandlerStatus() {
		return handlerStatus;
	}
	
	public void setHandlerStatus(String handlerStatus) {
		this.handlerStatus = handlerStatus;
	}
	
	public Integer getApplicantUserId() {
		return applicantUserId;
	}
	
	public void setApplicantUserId(Integer applicantUserId) {
		this.applicantUserId = applicantUserId;
	}
	
	public String getApplicantName() {
		return applicantName;
	}
	
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	
	public Integer getHandlerUserId() {
		return handlerUserId;
	}
	
	public void setHandlerUserId(Integer handlerUserId) {
		this.handlerUserId = handlerUserId;
	}
	
	public String getHandlerName() {
		return handlerName;
	}
	
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	
	public String getItemContent() {
		return itemContent;
	}
	
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	
}
