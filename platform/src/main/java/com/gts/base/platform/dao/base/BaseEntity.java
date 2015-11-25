package com.gts.base.platform.dao.base;

import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.gts.base.platform.dao.plugin.Page;

/**
 * @Description: 基本实体类
 * @ClassName: BaseEntity
 * @author gaoxiang
 * @date 2015年11月24日 下午10:56:20
 */
public class BaseEntity {
	
	/**
	 * @Fields gmtCreate : 创建时间
	 */
	private Date gmtCreate;
	
	/**
	 * @Fields gmtModify : 修改时间
	 */
	private Date gmtModify;
	
	private Page page;
	
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	public Date getGmtModify() {
		return gmtModify;
	}
	
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
	
	public String toString() {
		try {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		} catch (Exception e) {
			// NOTICE: 这样做的目的是避免由于toString()的异常导致系统异常终止
			// 大部分情况下，toString()用在日志输出等调试场景
			return super.toString();
		}
	}
	
}
