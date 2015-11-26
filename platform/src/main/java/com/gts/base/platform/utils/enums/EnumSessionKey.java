package com.gts.base.platform.utils.enums;

public enum EnumSessionKey {
	
	USER_KEY("session_user","登录用户信息"),
	IMG_CODE_KEY("session_img_code","图片验证码");
	
	private EnumSessionKey(String key,String msg){
		this.key = key;
		this.msg = msg;
	}
	
	private String key;
	
	private String msg;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
