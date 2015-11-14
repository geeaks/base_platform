package com.gts.base.platform.test.util;

import org.junit.Before;
import org.junit.Test;
import com.gts.base.platform.test.BaseTest;
import redis.clients.jedis.Jedis;

public class JedisUtilTest extends BaseTest {
	
	private Jedis jedis;
	
	@Before
	public void setup() {
		jedis = new Jedis("192.168.99.172", 6379);
	}
	
	@Test
	public void test(){
		jedis.set("test", "test");
		System.out.println(jedis.get("test"));
	}
}
