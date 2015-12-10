package com.gts.base.platform.dao.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import com.gts.base.platform.dao.base.BaseDao;
import com.gts.base.platform.dao.interceptor.annotation.Datasource;
import com.gts.framework.core.aop.BaseInterceptor;
import com.gts.framework.core.util.SpringContextUtil;
import com.gts.framework.log.service.GtsLogger;
import com.gts.framework.log.util.GtsLoggerFactory;

/**
 * @Description: 动态数据源拦截器
 * @ClassName: DynamicDataSourceInterceptor
 * @author gaoxiang
 * @date 2015年12月10日 下午5:05:44
 */ 
public class DynamicDataSourceInterceptor extends BaseInterceptor {
	
	private final GtsLogger LOGGER = GtsLoggerFactory.getLogger(getClass());
	
	@Override
	public Object bizInvoke(MethodInvocation invocation) throws Throwable {
		try {
			Datasource datasource = AnnotationUtils.findAnnotation(invocation.getMethod(), Datasource.class);
			//未加注解 则用默认的数据源
			if(datasource != null){
				BaseDao baseDao = (BaseDao) invocation.getThis();
				ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
				baseDao.setSqlSessionTemplate((SqlSessionTemplate) applicationContext.getBean(datasource.value().getDataSourceId()));
				LOGGER.info("Invoke method:【"+invocation.getMethod().getName()+"】,set dataSouce:【"+datasource.value().getDataSourceId()+"】");
			}
		} catch (Exception e) {
			LOGGER.error("切换数据源系统异常", e);
		}
		return invocation.proceed();
	}
	
}
