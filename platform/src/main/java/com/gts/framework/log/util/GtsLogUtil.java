package com.gts.framework.log.util;

import java.text.MessageFormat;
import org.apache.commons.lang.StringUtils;
import com.gts.framework.log.service.GtsLogger;

/**
 * @Description: 日志工具
 * @ClassName: GtsLogUtil
 * @author gaoxiang
 * @date 2015年11月17日 下午10:46:00
 */ 
public class GtsLogUtil {
	
	private static final GtsLogger logger = GtsLoggerFactory.getLogger(GtsLogUtil.class);
	
	/**
	 * 输出info level的log信息.
	 * @param logger 日志记录器
	 * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	public static void info(GtsLogger logger, String message, Object... params) {
		if (logger.isInfoEnabled()) {
			logger.info(format(message, params));
		}
	}
	
	/**
	 * 输出info level的log信息.
	 * 
	 * @param throwable
	 *            异常对象
	 * @param logger
	 *            日志记录器
	 * @param message
	 *            log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params
	 *            log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	public static void info(Throwable throwable, GtsLogger logger, String message, Object... params) {
		if (logger.isInfoEnabled()) {
			logger.info(format(message, params), throwable);
		}
	}
	
	/**
	 * 输出warn level的log信息.
	 * 
	 * @param logger
	 *            日志记录器
	 * @param message
	 *            log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params
	 *            log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	public static void warn(GtsLogger logger, String message, Object... params) {
		if (logger.isWarnEnabled()) {
			logger.warn(format(message, params));
		}
	}
	
	/**
	 * 输出warn level的log信息.
	 * 
	 * @param throwable
	 *            异常对象
	 * @param logger
	 *            日志记录器
	 * @param message
	 *            log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params
	 *            log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	public static void warn(Throwable throwable, GtsLogger logger, String message, Object... params) {
		if (logger.isWarnEnabled()) {
			logger.warn(format(message, params), throwable);
		}
	}
	
	/**
	 * 输出debug level的log信息.
	 * 
	 * @param logger
	 *            日志记录器
	 * @param message
	 *            log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params
	 *            log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	public static void debug(GtsLogger logger, String message, Object... params) {
		if (logger.isDebugEnabled()) {
			logger.debug(format(message, params));
		}
	}
	
	/**
	 * 输出debug level的log信息.
	 * 
	 * @param throwable
	 *            异常对象
	 * @param logger
	 *            日志记录器
	 * @param message
	 *            log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params
	 *            log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	public static void debug(Throwable throwable, GtsLogger logger, String message, Object... params) {
		if (logger.isDebugEnabled()) {
			logger.debug(format(message, params), throwable);
		}
	}
	
	/**
	 * 输出error level的log信息.
	 * 
	 * @param logger
	 *            日志记录器
	 * @param message
	 *            log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params
	 *            log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	public static void error(GtsLogger logger, String message, Object... params) {
		if (logger.isErrorEnabled()) {
			logger.error(format(message, params));
		}
	}
	
	/**
	 * 输出error level的log信息.
	 * 
	 * @param throwable
	 *            异常对象
	 * @param logger
	 *            日志记录器
	 * @param message
	 *            log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params
	 *            log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	public static void error(Throwable throwable, GtsLogger logger, String message, Object... params) {
		if (logger.isErrorEnabled()) {
			logger.error(format(message, params), throwable);
		}
	}
	
	/**
	 * 日志信息参数化格式化
	 * 
	 * @param message
	 *            log信息,如:<code>xxx{0},xxx{1}...</code>
	 * @param params
	 *            log格式化参数,数组length与message参数化个数相同, 如: <code>Object[]  object=new Object[]{"xxx","xxx"}</code>
	 */
	private static String format(String message, Object... params) {
		if (params != null && params.length != 0) {
			return messageFormat(message, params);
		}
		return message;
		
	}
	
	/**
	 * 格式化消息信息
	 * 
	 * @param message
	 * @param args
	 * @return消息信息 x
	 */
	private static String messageFormat(String message, Object... args) {
		try {
			if (StringUtils.isBlank(message)) {
				return "";
			}
			String str = MessageFormat.format(message, args);
			return str;
		} catch (Exception e) {
			logger.error("Log日志工具类messageFormat(String message,Object... args)发生异常:", e);
		}
		return "";
	}
}
