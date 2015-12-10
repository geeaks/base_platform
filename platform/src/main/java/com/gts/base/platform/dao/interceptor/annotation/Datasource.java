package com.gts.base.platform.dao.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.gts.base.platform.dao.interceptor.enums.EnumDataSource;

@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Datasource {
	
	/**
	 * @Description: 选定数据源 默认mysql的
	 * @return EnumDataSource 返回类型
	 * @author gaoxiang
	 * @date 2015年12月10日 下午5:04:27
	 */
	EnumDataSource value() default EnumDataSource.Mysql;
	
}
