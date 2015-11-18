package com.gts.framework.log.service.impl;

import org.slf4j.Logger;
import com.gts.framework.log.service.GtsLogger;

/**
 * @Description: 日志接口实现
 * @ClassName: GtsLoggerImpl
 * @author gaoxiang
 * @date 2015年11月17日 下午10:46:44
 */
public class GtsLoggerImpl implements GtsLogger {
	
	protected Logger logger = null;
	
	public void setLogger(Logger loger) {
		logger = loger;
	}
	
	public String getName() {
		return logger.getName();
	}
	
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}
	
	public void trace(String msg) {
		logger.trace(msg);
		
	}
	
	public void trace(String format, Object arg) {
		logger.trace(format, arg);
		
	}
	
	public void trace(String format, Object[] argArray) {
		logger.trace(format, argArray);
		
	}
	
	public void trace(String msg, Throwable t) {
		logger.trace(msg, t);
		
	}
	
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}
	
	public void debug(String message) {
		logger.debug(message);
	}
	
	public void debug(String format, Object arg) {
		logger.debug(format, arg);
	}
	
	public void debug(String format, Object[] argArray) {
		logger.debug(format, argArray);
	}
	
	public void debug(String message, Throwable t) {
		logger.debug(message, t);
	}
	
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}
	
	public void info(String message) {
		logger.info(message);
	}
	
	public void info(String format, Object arg) {
		logger.info(format, arg);
		
	}
	
	public void info(String format, Object[] argArray) {
		logger.info(format, argArray);
	}
	
	public void info(String msg, Throwable t) {
		logger.info(msg, t);
	}
	
	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}
	
	public void warn(String msg) {
		logger.warn(msg);
		
	}
	
	public void warn(String format, Object arg) {
		logger.warn(format, arg);
		
	}
	
	public void warn(String format, Object[] argArray) {
		logger.warn(format, argArray);
		
	}
	
	public void warn(String msg, Throwable t) {
		logger.warn(msg, t);
		
	}
	
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}
	
	public void error(String message) {
		logger.error(message);
	}
	
	public void error(String message, Throwable t) {
		logger.error(message, t);
	}
	
}
