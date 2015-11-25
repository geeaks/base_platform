package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 客户信息 实体
 * @ClassName: Customer
 * @author gaoxiang
 * @date 2015年11月24日 下午11:58:51
 */ 
public class Customer extends BaseEntity {
	
	/**
	 * @Fields customerId : 客户ID
	 */
	private Integer customerId;
	
	/**
	 * @Fields name : 客户姓名
	 */
	private String name;
	
	/**
	 * @Fields certType : 证件类型
	 */ 
	private String certType;
	
	/**
	 * @Fields certNo : 证件号码
	 */ 
	private String certNo;

	
	public Integer getCustomerId() {
		return customerId;
	}

	
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getCertType() {
		return certType;
	}

	
	public void setCertType(String certType) {
		this.certType = certType;
	}

	
	public String getCertNo() {
		return certNo;
	}

	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
}
