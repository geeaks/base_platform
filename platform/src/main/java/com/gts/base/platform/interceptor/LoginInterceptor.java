package com.gts.base.platform.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.gts.base.platform.service.bo.UserBo;
import com.gts.base.platform.utils.enums.EnumSessionKey;

/**
 * @Description: 登录拦截器
 * @ClassName: LoginInterceptor
 * @author gaoxiang
 * @date 2015年11月17日 下午11:24:13
 */ 
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		UserBo userBo = (UserBo) session.getAttribute(EnumSessionKey.USER_KEY.getKey());
		if(userBo == null){
			request.setAttribute("msg", "请重新登录");
			response.sendRedirect(request.getContextPath()+"/index?"+EnumSessionKey.REDIRECT_URL.getKey()+"=" + request.getRequestURL());
			return false;
		}
		return true;
	}
	
}
