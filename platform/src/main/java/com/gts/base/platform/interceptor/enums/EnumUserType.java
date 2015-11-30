package com.gts.base.platform.interceptor.enums;


/**
 * @Description: 登录用户权限控制 枚举常量
 * @ClassName: EnumMemberUserType
 * @author gaoxiang
 * @date 2015年11月30日 下午10:42:33
 */ 
public enum EnumUserType {
	
	Student("学生", 0), Genearch("家长", 1),Teacher("教师", 2),Manager("管理员", 3);
	
	private String name;
	private int code;

	EnumUserType(String name, int code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public static EnumUserType getByCode(int code) {
		for (EnumUserType enunEnumMemberUserType : EnumUserType
				.values()) {
			if (enunEnumMemberUserType.code == code) {
				return enunEnumMemberUserType;
			}
		}
		return null;
	}
}
