package com.gts.base.platform.dao.interceptor.enums;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @ClassName: EnumDataSource
 * @author gaoxiang
 * @date 2015年12月10日 下午5:04:06
 */ 
public enum EnumDataSource {
	
	Mysql("mysql_sqlSessionTemplate", ""),Oracle("oracle_sqlSessionTemplate", "");
	
	private String dataSourceId;
	
	private String dataSourceDesc;
	
	EnumDataSource(String dataSourceId, String dataSourceDesc) {
		this.dataSourceId = dataSourceId;
		this.dataSourceDesc = dataSourceDesc;
	}
	
	public String getDataSourceId() {
		return dataSourceId;
	}
	
	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}
	
	public String getDataSourceDesc() {
		return dataSourceDesc;
	}
	
	public void setDataSourceDesc(String dataSourceDesc) {
		this.dataSourceDesc = dataSourceDesc;
	}
}
