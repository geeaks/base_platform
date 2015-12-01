package com.gts.base.platform.utils.enums;

/**
 * @Description: 用户类型枚举常量
 * @ClassName: EnumUserType
 * @author gaoxiang
 * @date 2015年11月28日 下午1:35:52
 */
public enum EnumUserType {
	
	Student("student", "学生类型", "同学"), 
	Teacher("teacher", "教师类型", "老师"), 
	Manager("teacher", "教师类型", "管理员"), 
	Genearch("genearch", "家长类型", "家长");
	
	private EnumUserType(String type, String desc, String identity) {
		this.type = type;
		this.desc = desc;
		this.identity = identity;
	}
	
	private String type;
	
	private String desc;
	
	private String identity;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getIdentity() {
		return identity;
	}
	
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public static String getUserDignity(String userType) {
		for (EnumUserType enumUserType : EnumUserType.values()) {
			if (enumUserType.getType().equals(userType)) {
				return enumUserType.getIdentity();
			}
		}
		return null;
	}
}
