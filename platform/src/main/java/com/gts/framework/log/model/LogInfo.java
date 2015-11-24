package com.gts.framework.log.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import com.gts.framework.core.context.ProductContext;
import com.gts.framework.core.context.ProductContextHolder;
import com.gts.framework.core.model.GtsBaseModel;
import com.gts.framework.log.enums.LoggerLevel;

/**
 * @Description: 日志数据
 * @ClassName: LogInfo
 * @author gaoxiang
 * @date 2015年11月17日 下午10:32:57
 */ 
public abstract class LogInfo extends GtsBaseModel {
	
	private static final long serialVersionUID = 7419129125801133567L;
	
	/**
	 * 被代理拦截的方法名
	 */
	private String interceptorMethod;
	
	/**
	 * 被代理拦截的类
	 */
	private String interceptorClass;
	
	/**
	 * 日志级别(默认INFO级别)
	 */
	private LoggerLevel loggerLevel = LoggerLevel.INFO;
	
	/**
	 * log记录标识
	 */
	private String logId;
	
	/**
	 * 日志文件的名字
	 * 
	 */
	private String logFileName;
	
	/**
	 * 计时器
	 */
	private StopWatch stopWatch;
	
	/**
	 * @return Returns the logId.
	 */
	public String getLogId() {
		return logId;
	}
	
	/**
	 * @param logId The logId to set.
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}
	
	/**
	 * @return Returns the interceptorMethod.
	 */
	public String getInterceptorMethod() {
		return interceptorMethod;
	}
	
	/**
	 * @param interceptorMethod The interceptorMethod to set.
	 */
	public void setInterceptorMethod(String interceptorMethod) {
		this.interceptorMethod = interceptorMethod;
	}
	
	/**
	 * @return Returns the interceptorClass.
	 */
	public String getInterceptorClass() {
		return interceptorClass;
	}
	
	/**
	 * @param interceptorClass
	 *            The interceptorClass to set.
	 */
	public void setInterceptorClass(String interceptorClass) {
		this.interceptorClass = interceptorClass;
	}
	
	/**
	 * @return Returns the loggerLevel.
	 */
	public LoggerLevel getLoggerLevel() {
		return loggerLevel;
	}
	
	/**
	 * @param loggerLevel
	 *            The loggerLevel to set.
	 */
	public void setLoggerLevel(LoggerLevel loggerLevel) {
		this.loggerLevel = loggerLevel;
	}
	
	public String getLogFileName() {
		return logFileName;
	}
	
	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}
	
	public StopWatch getStopWatch() {
		return stopWatch;
	}
	
	public void setStopWatch(StopWatch stopWatch) {
		this.stopWatch = stopWatch;
	}
	
	/**
	 * 生成日志信息 各业务自己负责自己的日志信息
	 */
	public abstract String toLogString();
	
	/**
	 * 获取环境数据
	 * @return
	 */
	protected String getEnvironmentInfo() {
		StringBuffer sb = new StringBuffer(getLogId());
		ProductContext productContext = ProductContextHolder.getProductContext();
		/**
		 * logId[(客户端IP,服务端IP)(SessionId)(referer)]
		 */
		sb.append("[(").append(StringUtils.trimToEmpty(productContext.getEnvironment().getClientIp())).append(",");// 客户端IP
		sb.append(StringUtils.trimToEmpty(productContext.getEnvironment().getServerIp())).append(")");// 服务端IP
		sb.append("(").append(StringUtils.trimToEmpty(productContext.getEnvironment().getSessionId())).append(")");// 用户会话
		sb.append("(").append(StringUtils.trimToEmpty(productContext.getReferer())).append(")]-");// referer
		return sb.toString();
	}
}
