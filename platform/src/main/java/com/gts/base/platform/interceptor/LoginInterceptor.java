package com.gts.base.platform.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Description: 登录拦截器
 * @ClassName: LoginInterceptor
 * @author gaoxiang
 * @date 2015年11月17日 下午11:24:13
 */ 
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}
	
}
