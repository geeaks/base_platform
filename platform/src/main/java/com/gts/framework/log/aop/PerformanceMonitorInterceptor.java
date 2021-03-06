package com.gts.framework.log.aop;

import org.aopalliance.intercept.MethodInvocation;
import com.gts.framework.core.aop.BaseInterceptor;
import com.gts.framework.core.diagnostic.Profiler;
import com.gts.framework.log.service.GtsLogger;
import com.gts.framework.log.util.GtsLoggerFactory;

/**
 * @Description: 性能监控
 * @ClassName: PerformanceMonitorInterceptor
 * @author gaoxiang
 * @date 2015年11月17日 下午10:32:33
 */ 
public class PerformanceMonitorInterceptor extends BaseInterceptor {
	
	private final static GtsLogger logger = GtsLoggerFactory.getLogger(PerformanceMonitorInterceptor.class);
	
	/** 以毫秒表示的阈值 */
	private int threshold = 250;
	
	/**
	 * 判断方法调用的时间是否超过阈值，如果是，则打印性能日志.
	 * 
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object bizInvoke(MethodInvocation invocation) throws Throwable {
		StringBuilder builder = new StringBuilder(64);
		builder.append(invocation.getMethod().getDeclaringClass().getName());
		builder.append(".");
		builder.append(invocation.getMethod().getName());
		String name = builder.toString();
		Profiler.start("Invoking method: " + name);
		try {
			return invocation.proceed();
		} finally {
			Profiler.release();
			if (!Profiler.isSuperStart()) {
				long elapseTime = Profiler.getDuration();
				
				if (elapseTime > threshold) {
					StringBuilder builderTmp = new StringBuilder();
					builderTmp.append(" method ").append(name);
					// 执行时间超过阈值时间
					builderTmp.append(" over PMX = ").append(threshold).append("ms,");
					// 实际执行时间为
					builderTmp.append(" used P = ").append(elapseTime).append("ms.\r\n");
					builderTmp.append(Profiler.dump());
					logger.info(builderTmp.toString());
				} else {
					if (logger.isDebugEnabled()) {
						StringBuilder builderTmp = new StringBuilder();
						builderTmp.append("method").append(name);
						// 实际执行时间为
						builderTmp.append(" used P = ").append(elapseTime).append("ms.\r\n");
						logger.debug(builderTmp.toString());
					}
				}
			}
			Profiler.reset();
		}
		
	}
	
	/**
	 * @param threshold The threshold to set.
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
}
