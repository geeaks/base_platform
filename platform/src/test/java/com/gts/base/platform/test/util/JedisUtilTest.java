package com.gts.base.platform.test.util;

import org.junit.Test;
import com.gts.base.platform.test.BaseTest;

/**
 * @Description: Jedis单元测试
 * @ClassName: JedisUtilTest
 * @author gaoxiang
 * @date 2015年11月15日 下午3:46:18
 */ 
public class JedisUtilTest extends BaseTest {
	
	@Test
	public void valueOperationsTest(){
		valueOperations.set("name", "geeaks");
		System.out.println(valueOperations.get("name"));
	}
}
