package com.gts.base.platform.service.bo;

import java.io.Serializable;
import com.gts.base.platform.dao.entity.LoginInfo;
import com.gts.framework.core.util.DateUtils;

/**
 * @Description: 用户登录信息业务实体
 * @ClassName: UserLoginInfo
 * @author gaoxiang
 * @date 2015年11月24日 下午11:00:24
 */
public class LoginInfoBo extends LoginInfo implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = 1604915439290306062L;
	
	protected String strLastLoginTime;
	
	public String getStrLastLoginTime() {
		return DateUtils.formatDate(this.getLastLoginTime());
	}
	
	public void setStrLastLoginTime(String strLastLoginTime) {
		this.strLastLoginTime = strLastLoginTime;
	}
	
}
