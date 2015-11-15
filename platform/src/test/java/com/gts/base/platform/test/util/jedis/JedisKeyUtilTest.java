package com.gts.base.platform.test.util.jedis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.gts.base.platform.test.BaseTest;

/**
 * @Description: Redis 键命令用于管理 redis 的键
 * @ClassName: JedisKeyUtilTest
 * @author gaoxiang
 * @date 2015年11月15日 下午4:06:17
 */ 
public class JedisKeyUtilTest extends BaseTest {
	
	/**
	 * @Description: 用于在 key 存在时候删除 key
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:06:48
	 */
	@Test
	public void deleteTest(){
		redisTemplate.delete("nameKey");
	}
	
	/**
	 * @Description: 序列化给定 key，并返回被序列化的值
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:07:58
	 */
	@Test
	public void dumpTest(){
		System.out.println(redisTemplate.dump("nameKey"));
	}
	
	/**
	 * @Description: 检查给定 key 是否存在
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:08:41
	 */
	@Test
	public void hasKeyTest(){
		System.out.println(redisTemplate.hasKey("nameKey"));
	}
	
	/**
	 * @Description: 为给定 key 设置过期时间
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:10:05
	 */
	@Test
	public void expireTest(){
		redisTemplate.expire("nameKey", 100, TimeUnit.SECONDS);
	}
	
	/**
	 * @Description: 以秒为单位，返回给定 key 的剩余生存时间
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:10:38
	 */
	@Test
	public void getExpireTest(){
		System.out.println(redisTemplate.getExpire("nameKey",TimeUnit.SECONDS));
	}
	
	/**
	 * @Description: 移除 key 的过期时间，key 将持久保持
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:11:09
	 */
	@Test
	public void persistTest(){
		redisTemplate.persist("nameKey");
	}
	
	/**
	 * @Description: 查找所有符合给定模式( pattern)的 key *是通配符
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:11:48
	 */
	@Test
	public void keysTest(){
		Set<String> keys = redisTemplate.keys("name*");
		System.out.println(JSON.toJSONString(keys));
	}
	
	/**
	 * @Description: 从当前数据库中随机返回一个 key
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:12:39
	 */
	@Test
	public void randomKeyTest(){
		System.out.println(redisTemplate.randomKey());
	}
	
	/**
	 * @Description: 修改 key 的名称
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:13:07
	 */
	@Test
	public void renameTest(){
		redisTemplate.rename("nameKey", "newKey");
	}
	
	/**
	 * @Description: 仅当 newkey不存在时，将 key改名为 newkey
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:13:28
	 */
	@Test
	public void renameIfAbsentTest(){
		redisTemplate.renameIfAbsent("nameKey", "newKey");
		//返回 key 所储存的值的类型
		System.out.println(redisTemplate.type("nameKey"));
	}
	
	/**
	 * @Description: 返回 key 所储存的值的类型
	 * @return void 返回类型
	 * @author gaoxiang
	 * @date 2015年11月15日 下午4:14:05
	 */
	@Test
	public void typeTest(){
		System.out.println(redisTemplate.type("nameKey"));
	}
}
