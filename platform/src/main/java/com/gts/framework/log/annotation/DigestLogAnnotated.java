package com.gts.framework.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.gts.framework.log.enums.LoggerLevel;
import com.gts.framework.log.enums.LoggerPrintType;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DigestLogAnnotated {
	
	/**
	 * @Description: 日志文件名
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:33:52
	 */
	public String logFileName();
	
	/**
	 * @Description: 日志记录级别
	 * @return LoggerLevel 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:34:04
	 */
	public LoggerLevel loggerLevel();
	
	/**
	 * @Description: 摘要标识码
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:34:13
	 */
	public String digestIdentificationCode();
	
	/**
	 * @Description: 日志输出类型
	 * @return
	 * @return LoggerPrintType 返回类型
	 * @author gaoxiang
	 * @date 2015年11月17日 下午10:34:28
	 */
	public LoggerPrintType printType() default LoggerPrintType.ALL;
	
}
