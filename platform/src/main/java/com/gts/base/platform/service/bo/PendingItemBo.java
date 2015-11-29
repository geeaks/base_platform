package com.gts.base.platform.service.bo;

import java.io.Serializable;
import com.gts.base.platform.dao.entity.PendingItem;
import com.gts.framework.core.util.DateUtils;

/**
 * @Description: 待办事项 业务实体
 * @ClassName: Customer
 * @author gaoxiang
 * @date 2015年11月24日 下午11:58:51
 */
public class PendingItemBo extends PendingItem implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = 7494757752303024694L;
	
	protected String strGmtCreate;
	
	protected String strGmtModify;
	
	public String getStrGmtCreate() {
		return DateUtils.formatDate(this.getGmtCreate());
	}
	
	public void setStrGmtCreate(String strGmtCreate) {
		this.strGmtCreate = strGmtCreate;
	}
	
	public String getStrGmtModify() {
		return DateUtils.formatDate(this.getGmtModify());
	}
	
	public void setStrGmtModify(String strGmtModify) {
		this.strGmtModify = strGmtModify;
	}
	
}
