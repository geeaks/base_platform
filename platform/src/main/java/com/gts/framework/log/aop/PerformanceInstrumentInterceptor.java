package com.gts.framework.log.aop;

import org.aopalliance.intercept.MethodInvocation;

import com.gts.framework.core.aop.BaseInterceptor;
import com.gts.framework.core.diagnostic.Profiler;

/**
 * @Description: 性能日志拦截
 * @ClassName: PerformanceInstrumentInterceptor
 * @author gaoxiang
 * @date 2015年11月17日 下午10:32:07
 */ 
public class PerformanceInstrumentInterceptor extends BaseInterceptor {
	
	/**
	 * 判断方法调用的时间是否超过阈值，如果是，则打印性能日志.
	 */
	@Override
	public Object bizInvoke(MethodInvocation invocation) throws Throwable {
		StringBuilder builder = new StringBuilder(64);
		builder.append("Invoking method: ");
		builder.append(invocation.getMethod().getDeclaringClass().getName());
		builder.append(".");
		builder.append(invocation.getMethod().getName());
		Profiler.enter(builder.toString());
		try {
			return invocation.proceed();
		} finally {
			Profiler.release();
		}
	}
}
