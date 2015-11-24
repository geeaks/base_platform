package com.gts.framework.core.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @Description: 基础model
 * @ClassName: UcfBaseModel
 * @author gaoxiang
 * @date 2015年11月17日 下午10:50:24
 */ 
public abstract class GtsBaseModel implements Serializable {
	
	private static final long serialVersionUID = 8102332839758942806L;
	
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
