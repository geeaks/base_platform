package com.gts.base.platform.dao.entity;

import com.gts.base.platform.dao.base.BaseEntity;

/**
 * @Description: 用户信息实体
 * @ClassName: User
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class User extends BaseEntity {
	
	/**
	 * @Fields userId : 用户ID
	 */
	private Integer userId;
	
	/**
	 * @Fields roleId : 角色ID
	 */
	private Integer roleId;
	
	/**
	 * @Fields userType : 用户类型
	 */
	private String userType;
	
	/**
	 * @Fields customerId : 客户ID
	 */
	private Integer customerId;
	
	/**
	 * @Fields certType : 证件类型
	 */
	private String certType;
	
	/**
	 * @Fields certNO : 证件号
	 */
	private String certNo;
	
	/**
	 * @Fields name : 用户姓名
	 */
	private String name;
	
	/**
	 * @Fields nickName : 用户昵称
	 */
	private String nickName;
	
	/**
	 * @Fields age : 年龄
	 */
	private Integer age;
	
	/**
	 * @Fields gender : 性别
	 */
	private String gender;
	
	/**
	 * @Fields email : 邮箱
	 */
	private String email;
	
	/**
	 * @Fields phone : 座机号码
	 */
	private String phone;
	
	/**
	 * @Fields mobile : 手机号码
	 */
	private String mobile;
	
	/**
	 * @Fields job : 职位
	 */
	private String job;
	
	/**
	 * @Fields province : 省份
	 */
	private String province;
	
	/**
	 * @Fields city : 城市
	 */
	private String city;
	
	/**
	 * @Fields area : 区域
	 */
	private String area;
	
	/**
	 * @Fields address : 具体住址
	 */
	private String address;
	
	/**
	 * @Fields securityCode : 安全码，防钓鱼
	 */
	private String securityCode;
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getSecurityCode() {
		return securityCode;
	}
	
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
