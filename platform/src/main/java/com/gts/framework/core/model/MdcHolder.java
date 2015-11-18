package com.gts.framework.core.model;

import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import com.gts.framework.log.service.GtsLogger;
import com.gts.framework.log.util.GtsLoggerFactory;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @ClassName: MdcHolder
 * @author gaoxiang
 * @date 2015年11月17日 下午10:49:26
 */ 
public class MdcHolder {
	
	private final static GtsLogger logger = GtsLoggerFactory.getLogger(MdcHolder.class);
	
	public static final String MDC_REQUEST_ID_KEY = "MDC_REQUEST_ID";
	
	public static final String MDC_SESSION_KEY = "MDC_SESSION";
	
	public static final String MDC_CLIENT_IP_KEY = "MDC_CLIENT_IP";
	
	public static final String MDC_SERVER_IP_KEY = "MDC_SERVER_IP";
	
	private static ThreadLocal<Long> MDC_COUNT = new ThreadLocal<Long>() {
		
		// 初始化值
		public Long initialValue() {
			return 0L;
		}
	};
	
	/**
	 * 初始化
	 * 
	 * @param productContext
	 */
	public static void init(ProductContext productContext) {
		try {
			MDC.put(MDC_REQUEST_ID_KEY, productContext.getRequestId());
			if (null != productContext.getEnvironment()) {
				if (StringUtils.isNotBlank(productContext.getEnvironment().getSessionId()))
					MDC.put(MDC_SESSION_KEY, productContext.getEnvironment().getSessionId());
				if (StringUtils.isNotBlank(productContext.getEnvironment().getClientIp()))
					MDC.put(MDC_CLIENT_IP_KEY, productContext.getEnvironment().getClientIp());
				if (StringUtils.isNotBlank(productContext.getEnvironment().getServerIp()))
					MDC.put(MDC_SERVER_IP_KEY, productContext.getEnvironment().getServerIp());
			}
		} catch (Exception e) {
			logger.warn("initMDC:" + e.getMessage());
		} finally {
			MDC_COUNT.set(MDC_COUNT.get() + 1);
		}
	}
	
	public static void clean() {
		Long c = MDC_COUNT.get();
		if (null != c && c.longValue() > 1) {
			MDC_COUNT.set(MDC_COUNT.get() - 1L);
		} else {
			MDC_COUNT.set(0L);
			MDC.clear();
		}
	}
}
