package com.gts.framework.web.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import com.gts.framework.core.context.ProductContextHolder;

/**
 * @Description: 该类提供对Http Header的一些操作和访问
 * @ClassName: HttpHeaderUtils
 * @author gaoxiang
 * @date 2015年11月28日 上午3:15:42
 */ 
public final class HttpHeaderUtils {
	
	private final static String HTT_REQUEST_COOKIE_THREAD_CACHE = "_http_request_cookie_thread_cache_";
	
	/**
	 * @Description: 获得真实IP地址
	 * @param request
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月24日 下午10:47:00
	 */
	public static String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * @Description: 获得referer
	 * @param request
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月24日 下午10:47:11
	 */
	public static String getReferer(HttpServletRequest request) {
		return request.getHeader("Referer");
	}
	
	/**
	 * @Description: 获得所有的cookie
	 * @param request
	 * @return Map<String,Cookie> 返回类型
	 * @author gaoxiang
	 * @date 2015年11月24日 下午10:47:21
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Cookie> getAllCookie(HttpServletRequest request) {
		// NOTICE: 增加cache，是为了避免多次遍历cookie
		Map<String, Cookie> cookieMap = (Map<String, Cookie>) ProductContextHolder.getProductContext()
		        .find(HTT_REQUEST_COOKIE_THREAD_CACHE);
		if (null == cookieMap) {
			cookieMap = new HashMap<String, Cookie>();
			Cookie[] cookies = request.getCookies();
			if (null != cookies) {
				int length = cookies.length;
				for (int i = 0; i < length; i++) {
					cookieMap.put(cookies[i].getName(), cookies[i]);
				}
			}
			ProductContextHolder.getProductContext().put(HTT_REQUEST_COOKIE_THREAD_CACHE, cookieMap);
		}
		return cookieMap;
	}
	
	/**
	 * @Description: 取得某个cookie的值
	 * @param cookieName
	 * @param request
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月24日 下午10:47:33
	 */
	public static String getCookieValue(String cookieName, HttpServletRequest request) {
		Cookie cookie = getAllCookie(request).get(cookieName);
		if (cookie != null) {
			return cookie.getValue();
		} else {
			return "";
		}
	}
	
	/**
	 * @Description: 获得URL，同时附加所有参数
	 * @param request
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月24日 下午10:47:43
	 */
	@SuppressWarnings("rawtypes")
	public static String getRequestURLWithParameter(HttpServletRequest request) {
		StringBuffer buffer = request.getRequestURL();
		Map parameter = request.getParameterMap();
		if (null != parameter && !parameter.isEmpty()) {
			buffer.append("?");
			Iterator keys = parameter.keySet().iterator();
			String key = null;
			String[] value = null;
			while (keys.hasNext()) {
				key = (String) keys.next();
				value = request.getParameterValues(key);
				if ((null == value) || (value.length == 0)) {
					buffer.append(key).append("=").append("");
				} else if (value.length > 0) {
					buffer.append(key).append("=").append(value[0]);
				}
				if (keys.hasNext()) {
					buffer.append("&");
				}
			}
		}
		return buffer.toString();
	}
	
	/**
	 * @Description: 获得URL，不附加任何输入参数
	 * @param request
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月24日 下午10:47:52
	 */
	public static String getRequestURL(HttpServletRequest request) {
		StringBuffer buffer = request.getRequestURL();
		return buffer.toString();
	}
	
	/**
	 * 获得 Http://xxxx:yyy/
	 * @param request
	 * @return
	 */
	public static String getHttpRootAddress(HttpServletRequest request) {
		String protocol = request.getProtocol();
		if (StringUtils.isNotBlank(protocol)) {
			int p = protocol.indexOf("/");
			if (p > -1) {
				protocol = protocol.substring(0, p);
			}
		}
		StringBuffer buffer = new StringBuffer(protocol);
		buffer.append("://");
		buffer.append(request.getServerName());
		buffer.append(":");
		buffer.append(request.getServerPort());
		String contextPath = request.getContextPath();
		if (StringUtils.isNotBlank(contextPath)) {
			buffer.append("/").append(contextPath);
		}
		return buffer.toString();
	}
}
