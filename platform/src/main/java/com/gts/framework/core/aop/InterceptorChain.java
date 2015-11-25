package com.gts.framework.core.aop;

import java.util.ArrayList;
import java.util.List;
import org.aopalliance.intercept.MethodInvocation;
import com.google.common.collect.Lists;

/**
 * @Description: 简单的拦截器链路的实现
 * @ClassName: InterceptorChain
 * @author gaoxiang
 * @date 2015年11月17日 下午10:28:09
 */
public class InterceptorChain extends BaseInterceptor {
	
	private List<Interceptor> chains = Lists.newArrayList();
	
	@Override
	public Object bizInvoke(MethodInvocation invocation) throws Throwable {
		InterceptorChainSupport support = new InterceptorChainSupport(invocation, new ArrayList<Interceptor>(chains));
		return support.proceed();
	}
	
	public void setChains(List<Interceptor> chains) {
		this.chains = chains;
	}
	
}
