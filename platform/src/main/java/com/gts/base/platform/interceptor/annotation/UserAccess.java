package com.gts.base.platform.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.gts.base.platform.interceptor.enums.EnumUserType;

/**
 * @Description: 用户访问控制(针对后台方法)
 * @ClassName: UserAccess
 * @author gaoxiang
 * @date 2015年11月30日 下午10:59:29
 */ 
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAccess {
	
	/**
	 * @Description: 多个用户类型之间为或的关系
	 * @return EnumUserType[] 返回类型
	 * @author gaoxiang
	 * @date 2015年11月30日 下午11:00:03
	 */
	EnumUserType[] value() default {};

}
