package com.gts.framework.log.util;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gts.framework.log.service.GtsLogger;
import com.gts.framework.log.service.impl.GtsLoggerImpl;

/**
 * @Description: 日志工厂类
 * @ClassName: GtsLoggerFactory
 * @author gaoxiang
 * @date 2015年11月17日 下午10:45:07
 */
public class GtsLoggerFactory {
	
	/**
	 * Return a logger named according to the name parameter using the statically bound {@link ILoggerFactory} instance.
	 * @param name The name of the logger.
	 * @return logger
	 */
	public static GtsLogger getLogger(String name) {
		Logger logger = LoggerFactory.getLogger(name);
		GtsLoggerImpl loggerImpl = new GtsLoggerImpl();
		loggerImpl.setLogger(logger);
		return loggerImpl;
	}
	
	/**
	 * 根据所在类获取logger
	 * @param clazz the returned logger will be named after clazz
	 * @return logger
	 */
	public static GtsLogger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}
}
