package com.gts.base.platform.utils.enums;

/**
 * @Description: 用户类型枚举常量
 * @ClassName: EnumUserType
 * @author gaoxiang
 * @date 2015年11月28日 下午1:35:52
 */ 
public enum EnumStatus {
	
	SUCCESS("S", "成功"), FAIL("F", "失败"), ING("I", "处理中");
			
	private EnumStatus(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private String code;
	
	private String msg;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
