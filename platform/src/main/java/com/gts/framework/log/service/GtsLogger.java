package com.gts.framework.log.service;

/**
 * @Description: 日志输出接口
 * @ClassName: GtsLogger
 * @author gaoxiang
 * @date 2015年11月17日 下午10:40:24
 */
public interface GtsLogger {
	
	/**
	 * @Description: 获取logger实例名
	 * @return
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:40:45
	 */
	public String getName();
	
	/**
	 * @Description: 判断当前logger的日志级别，如果是trace返回true，否则返回false
	 * @return boolean 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:40:54
	 */
	public boolean isTraceEnabled();
	
	/**
	 * @Description: 以trace级别打印日志信息
	 * @param msg
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:41:04
	 */
	public void trace(String msg);
	
	/**
	 * @Description: 以trace级别打印日志信息格式: trace("trace.msg-{}",new String[]{"test"}) 日志显示结果：trace.msg-test
	 * @param format
	 * @param arg
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:41:17
	 */
	public void trace(String format, Object arg);
	
	/**
	 * @Description: 以trace级别打印日志信息格式: trace("trace.msg-{}",new String[]{"test"}) 日志显示结果：trace.msg-test
	 * @param format
	 * @param argArray
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:41:33
	 */
	public void trace(String format, Object[] argArray);
	
	/**
	 * @Description: 以trace级别打印日志信息，同时打印异常信息
	 * @param msg
	 * @param t
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:41:46
	 */
	public void trace(String msg, Throwable t);
	
	/**
	 * @Description: 判断当前logger的日志级别，如果是debug返回true，否则返回false
	 * @return boolean 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:41:59
	 */
	public boolean isDebugEnabled();
	
	/**
	 * @Description: 以debug级别打印日志信息
	 * @param msg
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:42:14
	 */
	public void debug(String msg);
	
	/**
	 * @Description: 以debug级别打印日志信息格式: debug("debug.msg-{}",new String[]{"test"}) 日志显示结果：debug.msg-test
	 * @param format
	 * @param arg
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:42:24
	 */
	public void debug(String format, Object arg);
	
	/**
	 * @Description: 以debug级别打印日志信息格式: debug("debug.msg-{}",new String[]{"test"}) 日志显示结果：debug.msg-test
	 * @param format
	 * @param argArray
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:42:40
	 */
	public void debug(String format, Object[] argArray);
	
	/**
	 * @Description: 以debug级别打印日志信息，同时打印异常信息
	 * @param msg
	 * @param t
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:42:51
	 */
	public void debug(String msg, Throwable t);
	
	/**
	 * @Description: 判断当前logger的日志级别，如果是info返回true，否则返回false
	 * @return boolean 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:43:00
	 */
	public boolean isInfoEnabled();
	
	/**
	 * @Description: 以trace级别打印日志信息
	 * @param msg
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:43:13
	 */
	public void info(String msg);
	
	/**
	 * @Description: 以info级别打印日志信息格式: info("info.msg-{}",new String[]{"test"}) 日志显示结果：info.msg-test
	 * @param format
	 * @param arg
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:43:22
	 */
	public void info(String format, Object arg);
	
	/**
	 * @Description: 以info级别打印日志信息格式: info("info.msg-{}",new String[]{"test"}) 日志显示结果：info.msg-test
	 * @param format
	 * @param argArray
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:43:42
	 */
	public void info(String format, Object[] argArray);
	
	/**
	 * @Description: 以info级别打印日志信息,同时打印异常信息
	 * @param msg
	 * @param t
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:43:51
	 */
	public void info(String msg, Throwable t);
	
	/**
	 * @Description: 判断当前logger的日志级别，如果是warn返回true，否则返回false
	 * @return boolean 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:44:00
	 */
	public boolean isWarnEnabled();
	
	/**
	 * 以warn级别打印日志信息
	 * @param msg the message string to be logged
	 */
	public void warn(String msg);
	
	/**
	 * 以warn级别打印日志信息格式: warn("warn.msg-{}",new String[]{"test"}) 日志显示结果：warn.msg-test
	 * @param format the format string
	 * @param arg the argument
	 */
	public void warn(String format, Object arg);
	
	/**
	 * 以warn级别打印日志信息格式: warn("warn.msg-{}",new String[]{"test"}) 日志显示结果：warn.msg-test
	 * @param format the format string
	 * @param argArray an array of arguments
	 */
	public void warn(String format, Object[] argArray);
	
	/**
	 * 以warn级别打印日志信息，同时打印异常信息
	 * @param msg the message accompanying the exception
	 * @param t the exception (throwable) to log
	 */
	public void warn(String msg, Throwable t);
	
	/**
	 * 判断当前logger的日志级别，如果是error返回true，否则返回false
	 */
	public boolean isErrorEnabled();
	
	/**
	 * 打印异常信息
	 * @param msg the message string to be logged
	 */
	public void error(String msg);
	
	/**
	 * 打印异常信息
	 * @param msg the message accompanying the exception
	 * @param t the exception (throwable) to log
	 */
	public void error(String msg, Throwable t);
}
