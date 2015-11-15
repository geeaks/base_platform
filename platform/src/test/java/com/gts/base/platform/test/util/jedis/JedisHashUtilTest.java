package com.gts.base.platform.test.util.jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.gts.base.platform.test.BaseTest;

/**
 * @Description: Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。Redis 中每个 hash 可以存储 232 - 1 键值对（40多亿）
 * @ClassName: JedisHashUtilTest
 * @author gaoxiang
 * @date 2015年11月15日 下午4:06:17
 */ 
public class JedisHashUtilTest extends BaseTest {
	
	/**
	 * @Description: Redis Hdel 命令用于删除哈希表 key 中的一个或多个指定字段，不存在的字段将被忽略
	 */
	@Test
	public void hdelTest(){
		hashOperations.delete("myhash", "filed1", "filed2", "filed3");
	}
	
	/**
	 * @Description: Redis Hexists 命令用于查看哈希表的指定字段是否存在
	 */
	@Test
	public void hasKeyTest(){
		Boolean hasKey = hashOperations.hasKey("myhash", "filed1");
		System.out.println(hasKey);
	}
	
	/**
	 * @Description: Redis Hget 命令用于返回哈希表中指定字段的值
	 */
	@Test
	public void hgetTest(){
		Object object = hashOperations.get("myhash", "filed1");
		System.out.println(JSON.toJSONString(object));
	}
	
	/**
	 * @Description: Redis Hgetall 命令用于返回哈希表中，所有的字段和值。在返回值里，紧跟每个字段名(field name)之后是字段的值(value)，所以返回值的长度是哈希表大小的两倍
	 */
	@Test
	public void entriesTest(){
		Map<String, Object> entries = hashOperations.entries("myhash");
		System.out.println(JSON.toJSONString(entries));
	}
	
	/**
	 * @Description: Redis Hincrby 命令用于为哈希表中的字段值加上指定增量值
	 *  增量也可以为负数，相当于对指定字段进行减法操作。
	 *  如果哈希表的 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。
	 *  如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。
	 *  对一个储存字符串值的字段执行 HINCRBY 命令将造成一个错误。
	 *  本操作的值被限制在 64 位(bit)有符号数字表示之内。 
	 */
	@Test
	public void incTest(){
		Long increment = hashOperations.increment("myhash", "field1", 1);
		System.out.println(increment);
	}
	
	/**
	 * @Description: Redis Hkeys 命令用于获取哈希表中的所有字段名
	 */
	@Test
	public void keysTest(){
		Set<String> keys = hashOperations.keys("myhash");
		System.out.println(JSON.toJSONString(keys));
	}
	
	/**
	 * @Description: Redis Hlen 命令用于获取哈希表中字段的数量
	 */
	@Test
	public void sizeTest(){
		Long size = hashOperations.size("myhash");
		System.out.println(JSON.toJSONString(size));
	}
	
	/**
	 * @Description: Redis Hmget 命令用于返回哈希表中，一个或多个给定字段的值。
	 * 如果指定的字段不存在于哈希表，那么返回一个 null 值
	 */
	@Test
	public void multiGetTest(){
		Set<String> hashKeys = Sets.newHashSet("filed1","filed2","filed3","filed4");
		List<Object> multiGet = hashOperations.multiGet("myhash", hashKeys);
		System.out.println(JSON.toJSONString(multiGet));
	}
	
	/**
	 * @Description: Redis Hmset 命令用于同时将多个 field-value (字段-值)对设置到哈希表中。
	 * 此命令会覆盖哈希表中已存在的字段。如果哈希表不存在，会创建一个空哈希表，并执行 HMSET 操作。 
	 */
	@Test
	public void multisetTest(){
		Map<String,Object> map = Maps.newHashMap();
		map.put("field1", "value1");
		map.put("field2", "value2");
		hashOperations.putAll("myhash", map);
	}
	
	/**
	 * @Description: Redis Hset 命令用于为哈希表中的字段赋值 。
	 * 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
	 * 如果字段已经存在于哈希表中，旧值将被覆盖。 
	 */
	@Test
	public void setTest(){
		hashOperations.put("myhash", "field1", "value1");
	}
	
	/**
	 * @Description:  Redis Hsetnx 命令用于为哈希表中不存在的的字段赋值 。
	 * 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
	 * 如果字段已经存在于哈希表中，操作无效。
	 * 如果 key 不存在，一个新哈希表被创建并执行 HSETNX 命令。
	 */
	@Test
	public void hsetNxTest(){
		hashOperations.putIfAbsent("myhash", "field1", "value1");
	}
	
	/**
	 * @Description: Redis Hvals 命令返回哈希表所有字段的值
	 */
	@Test
	public void valuesTest(){
		List<Object> values = hashOperations.values("myhash");
		System.out.println(JSON.toJSONString(values));
	}
	
}
