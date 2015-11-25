package com.gts.framework.log.aop;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gts.framework.core.aop.BaseInterceptor;
import com.gts.framework.core.context.ProductContextHolder;
import com.gts.framework.core.util.AnnotatedUtils;
import com.gts.framework.log.annotation.DigestLogAnnotated;
import com.gts.framework.log.enums.LoggerLevel;
import com.gts.framework.log.enums.LoggerPrintType;
import com.gts.framework.log.model.LogInfo;
import com.gts.framework.log.service.GtsLogger;
import com.gts.framework.log.util.DefaultDigestLogInfo;
import com.gts.framework.log.util.GtsLoggerFactory;

/**
 * @Description: 摘要日志拦截器
 * @ClassName: AnnotatedLogInterceptor
 * @author gaoxiang
 * @date 2015年11月17日 下午10:31:48
 */
public class AnnotationLogInterceptor extends BaseInterceptor {
	
	@Override
	public Object bizInvoke(MethodInvocation invocation) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		//开始记录时间
		stopWatch.start();
		
		Method method = invocation.getMethod();
		String className = method.getDeclaringClass().getSimpleName();
		String methodName = method.getName();
		String logId = ProductContextHolder.getProductContext().getRequestId();
		
		String argumentString = null;
		try {
			DigestLogAnnotated digestAnnotated = AnnotatedUtils.getAnnotated(DigestLogAnnotated.class, invocation);
			if (digestAnnotated != null) {
				if (LoggerPrintType.IGNORE_INPUT != digestAnnotated.printType()) {
					argumentString = convert2argumentList(invocation.getArguments());
				}
			}
			// 执行业务方法
			Object result = invocation.proceed();
			if (digestAnnotated != null) {
				if (LoggerPrintType.IGNORE_OUTPUT != digestAnnotated.printType()) {
					digestInvokeLog(className, methodName, digestAnnotated.logFileName(), digestAnnotated.loggerLevel(),
					        stopWatch, result, argumentString, null, true, logId,
					        digestAnnotated.digestIdentificationCode());
				} else {
					digestInvokeLog(className, methodName, digestAnnotated.logFileName(), digestAnnotated.loggerLevel(),
					        stopWatch, null, argumentString, null, true, logId,
					        digestAnnotated.digestIdentificationCode());
				}
			}
			return result;
		} catch (Throwable e) {
			boolean needThrow = true;
			DigestLogAnnotated digestAnnotated = AnnotatedUtils.getAnnotated(DigestLogAnnotated.class, invocation);
			if (digestAnnotated != null) {
				if (LoggerPrintType.IGNORE_INPUT != digestAnnotated.printType()) {
					argumentString = (StringUtils.isBlank(argumentString)
					        ? convert2argumentList(invocation.getArguments()) : argumentString);
				}
				if (LoggerPrintType.IGNORE_EXCEPTION != digestAnnotated.printType()) {
					digestInvokeLog(className, methodName, digestAnnotated.logFileName(), digestAnnotated.loggerLevel(),
					        stopWatch, null, argumentString, e, false, logId,
					        digestAnnotated.digestIdentificationCode());
				} else {
					digestInvokeLog(className, methodName, digestAnnotated.logFileName(), digestAnnotated.loggerLevel(),
					        stopWatch, null, argumentString, null, true, logId,
					        digestAnnotated.digestIdentificationCode());
				}
			}
			if (needThrow) {
				throw e;
			} else {
				return null;
			}
		}
	}
	
	/**
	 * @Description: 转换请求参数数组为请求参数列表
	 * @param arguments 请求参数数组
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午11:30:58
	 */
	private String convert2argumentList(Object[] arguments) {
		String returnStr = "";
		if (null != arguments) {
			returnStr = JSON.toJSONString(arguments, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
		}
		return returnStr;
	}
	
	/**
	 * @Description: 执行摘要日志记录
	 * @param className 类名
	 * @param methodName 方法名
	 * @param loggerName 日志名称
	 * @param logLevel 日志级别
	 * @param stopWatch 
	 * @param result 
	 * @param arguments 
	 * @param e 异常信息
	 * @param isInvokeSuccess 调用是否成功
	 * @param logId 日志ID
	 * @param digestIdentificationCode 
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午11:31:24
	 */
	protected void digestInvokeLog(String className, String methodName, String loggerName, LoggerLevel logLevel,
	        StopWatch stopWatch, Object result, String arguments, Throwable e, boolean isInvokeSuccess, String logId,
	        String digestIdentificationCode) {
		this.digestInvokeLog(className, methodName, loggerName, logLevel, stopWatch, result, arguments, e,
		        isInvokeSuccess, logId, digestIdentificationCode, false);
	}
	
	protected void digestInvokeLog(String className, String methodName, String loggerName, LoggerLevel logLevel,
	        StopWatch stopWatch, Object result, String arguments, Throwable e, boolean isInvokeSuccess, String logId,
	        String digestIdentificationCode, boolean isSensitiveInfo) {
		
		stopWatch.split();
		DefaultDigestLogInfo digestLogInfo = new DefaultDigestLogInfo();
		digestLogInfo.setLogId(logId);
		digestLogInfo.setInterceptorClass(className);
		digestLogInfo.setInterceptorMethod(methodName);
		digestLogInfo.setStopWatch(stopWatch);
		digestLogInfo.setLogFileName(loggerName);
		digestLogInfo.setLoggerLevel(logLevel);
		digestLogInfo.setDigestIdentificationCode(digestIdentificationCode);
		digestLogInfo.setRequestParams(arguments);
		digestLogInfo.setInvokeResult(result);
		digestLogInfo.setException(e);
		digestLogInfo.setInvokeSuccess(isInvokeSuccess);
		printLog(digestLogInfo);
		
	}
	
	/**
	 * @Description: 输出日志
	 * @param logInfo
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午11:32:15
	 */
	protected void printLog(LogInfo logInfo) {
		GtsLogger logger = GtsLoggerFactory.getLogger(logInfo.getLogFileName());
		switch (logInfo.getLoggerLevel()) {
		case DEBUG: {
			logger.debug(logInfo.toLogString());
			break;
		}
		case INFO: {
			logger.info(logInfo.toLogString());
			break;
		}
		case WARN: {
			logger.warn(logInfo.toLogString());
			break;
		}
		case ERROR: {
			logger.error(logInfo.toLogString());
			break;
		}
		default:
			break;
		}
	}
}
