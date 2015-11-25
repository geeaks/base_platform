package com.gts.framework.core.aop;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;
import org.aopalliance.intercept.MethodInvocation;
import com.gts.framework.log.service.GtsLogger;
import com.gts.framework.log.util.GtsLoggerFactory;

/**
 * @Description: 简单的拦截器链路的实现
 * @ClassName: InterceptorChainSupport
 * @author gaoxiang
 * @date 2015年11月17日 下午10:38:08
 */ 
class InterceptorChainSupport implements MethodInvocation {
	
	private final static GtsLogger logger = GtsLoggerFactory.getLogger(InterceptorChainSupport.class);
	
	private MethodInvocation proxy;
	
	private List<Interceptor> chains;
	
	public InterceptorChainSupport(MethodInvocation proxy, List<Interceptor> chains) {
		this.proxy = proxy;
		this.chains = chains;
	}
	
	public Method getMethod() {
		return proxy.getMethod();
	}
	
	public Object[] getArguments() {
		return proxy.getArguments();
	}
	
	public AccessibleObject getStaticPart() {
		return proxy.getStaticPart();
	}
	
	public Object getThis() {
		return proxy.getThis();
	}
	
	public Object proceed() throws Throwable {
		if (null != chains) {
			if (chains.size() > 0) {
				if (logger.isDebugEnabled()) {
					logger.debug(" [ " + Thread.currentThread().getId() + " ] Invoke Chanin [ " + chains.size()+ " ] , name is : " + chains.get(0).getClass());
				}
				return chains.remove(0).invoke(this);
			}
		}
		return proxy.proceed();
	}
	
}
