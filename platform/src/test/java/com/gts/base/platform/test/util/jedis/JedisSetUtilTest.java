package com.gts.base.platform.test.util.jedis;

import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.gts.base.platform.test.BaseTest;

/**
 * @Description: Redis的Set是string类型的无序集合。集合成员是唯一的，这就意味着集合中不能出现重复的数据。Redis 中 集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。 
 * @ClassName: JedisListUtilTest
 * @author gaoxiang
 * @date 2015年11月15日 下午4:06:17
 */ 
public class JedisSetUtilTest extends BaseTest {
	
	/**
	 * @Description: Redis Lpop 命令用于移除并返回列表的第一个元素
	 */
	@Test
	public void leftPopTest(){
		Long add = setOperations.add("key1", "value1");
		System.out.println(JSON.toJSONString(add));
	}
	
}
