package com.gts.base.platform.test.util.jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.gts.base.platform.test.BaseTest;

/**
 * @Description: Redis 字符串数据类型的相关命令用于管理 redis 字符串值
 * @ClassName: JedisStringUtilTest
 * @author gaoxiang
 * @date 2015年11月15日 下午4:06:17
 */ 
public class JedisStringUtilTest extends BaseTest {
	
	/**
	 * @Description: 设置指定 key 的值
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:06:48
	 */
	@Test
	public void setTest(){
		valueOperations.set("key1", "value1");
	}
	
	/**
	 * @Description: 获取指定 key的值
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:17:18
	 */
	@Test
	public void getTest(){
		Object value1 = valueOperations.get("key1");
		System.out.println(value1);
	}
	
	/**
	 * @Description: 返回 key中字符串值的子字符(end为-1表示到最后)
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:18:31
	 */
	@Test
	public void getTest2(){
		String value1 = valueOperations.get("key1", 0, 3);
		String value2 = valueOperations.get("key1", 0, -1);
		System.out.println(value1);
		System.out.println(value2);
	}
	
	/**
	 * @Description: 将给定key的值设为value，并返回key的旧值(old value)
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:20:58
	 */
	@Test
	public void getSetTest(){
		Object oldValue = valueOperations.getAndSet("key1", "newValue");
		System.out.println(oldValue);
	}
	
	/**
	 * @Description: 获取所有(一个或多个)给定key的值
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:22:29
	 */
	@Test
	public void multiGetTest(){
		Set<String> keys = Sets.newHashSet("key1","key2","key3");
		List<Object> list = valueOperations.multiGet(keys);
		System.out.println(list);
	}
	
	/**
	 * @Description: 将值 value关联到key，并将key的过期时间设为 seconds(以秒为单位)
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:32:29
	 */
	@Test
	public void setExpireTest(){
		valueOperations.set("key1", "value1", 100, TimeUnit.SECONDS);
	}
	
	/**
	 * @Description: 只有在key不存在时设置key的值
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:33:13
	 */
	@Test
	public void setNxTest(){
		valueOperations.setIfAbsent("key1", "value1");
	}
	
	/**
	 * @Description: 返回key所储存的字符串值的长度
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:34:36
	 */
	@Test
	public void sizeTest(){
		Long size = valueOperations.size("key1");
		System.out.println(size);
	}
	
	/**
	 * @Description: 同时设置一个或多个key-value对
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:36:10
	 */
	@Test
	public void mSetTest(){
		Map<String, String> map = ImmutableMap.of("key1","value1","key2","value2");
		valueOperations.multiSet(map);
	}
	
	/**
	 * @Description: 将key中储存的数字值增一
	 * @return void 返回类型 返回增长后的数字
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:43:51
	 */
	@Test
	public void incTest(){
		Long increment = valueOperations.increment("key3", 1);
		System.out.println(increment);
	}
	
	/**
	 * @Description: 如果key已经存在并且是一个字符串，将value追加到key原来的值的末尾,不存在等同于set
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:48:17
	 */
	@Test
	public void appendTest(){
		Integer append = valueOperations.append("key1", "value2");
		System.out.println(append);
	}
	
}
