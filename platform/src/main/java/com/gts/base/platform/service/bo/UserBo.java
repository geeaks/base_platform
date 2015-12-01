package com.gts.base.platform.service.bo;

import java.io.Serializable;
import com.gts.base.platform.dao.entity.User;
import com.gts.base.platform.utils.enums.EnumUserType;

/**
 * @Description: 用户信息实体
 * @ClassName: User
 * @author gaoxiang
 * @date 2015年11月24日 下午11:01:57
 */
public class UserBo extends User implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = 2405636837049314509L;
	
	/**
	 * @Fields userIdentity : 用户身份
	 */
	protected String userIdentity;
	
	public String getUserIdentity() {
		return EnumUserType.getUserDignity(this.getUserType());
	}
	
	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	
}
