package com.gts.framework.core.constants;

/**
 * @Description: 通用服务的常量定义
 * @ClassName: ServiceConstants
 * @author gaoxiang
 * @date 2015年11月17日 下午10:50:00
 */
public final class ServiceConstants {
	
	/**
	 * 服务调用的时候，没有返回结果值.0x10--- , 10区域分配给服务框架使用
	 */
	public final static int SERVICE_NO_RESULT = 0xFF0001;
	
	/**
	 * 发生系统级别的异常
	 */
	public final static int SERVICE_SYSTEM_FALIURE = 0xFF0002;
	
	/**
	 * 服务的方法参数少于1个，为规则所不允许
	 */
	public final static int SERVICE_METHOD_ARGS_LESS_THAN_1 = 0xFF0003;
	
	/**
	 * 构建当前被调用的服务的方法
	 */
	public final static String CONTEXT_INVOKE_METHOD = "invokeMethod";
	
	/**
	 * 当前服务所调用的方法及其环境对象
	 */
	public final static String CONTEXT_INVOCATION = "methodInvocation";
}
