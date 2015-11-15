package com.gts.base.platform.test.util.jedis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.gts.base.platform.test.BaseTest;

/**
 * @Description: Redis列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素导列表的头部（左边）或者尾部（右边）一个列表最多可以包含 232 - 1 个元素 (4294967295, 每个列表超过40亿个元素)。
 * @ClassName: JedisListUtilTest
 * @author gaoxiang
 * @date 2015年11月15日 下午4:06:17
 */ 
public class JedisListUtilTest extends BaseTest {
	
	/**
	 * @Description: Redis Lpop 命令用于移除并返回列表的第一个元素
	 */
	@Test
	public void leftPopTest(){
		Object leftPop = listOperations.leftPop("key1");
		System.out.println(JSON.toJSONString(leftPop));
	}
	
	/**
	 * @Description: Redis Lpush 命令将一个或多个值插入到列表头部。
	 * 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。
	 * 当 key 存在但不是列表类型时，返回一个错误。
	 * 执行 LPUSH 命令后，返回列表的长度。
	 */
	@Test
	public void leftPushTest(){
		Long leftPush = listOperations.leftPush("key1", "value1");
		System.out.println(JSON.toJSONString(leftPush));
	}
	
	/**
	 * @Description: Redis Rpush 命令用于将一个或多个值插入到列表的尾部(最右边)。
	 * 如果列表不存在，一个空列表会被创建并执行 RPUSH 操作。 当列表存在但不是列表类型时，返回一个错误。
	 */
	@Test
	public void rightPushTest(){
		Long rightPush = listOperations.rightPush("key1", "value1");
		System.out.println(JSON.toJSONString(rightPush));
	}
	
	/**
	 * @Description: Redis Lpushx 将一个或多个值插入到已存在的列表头部，列表不存在时操作无效。
	 */
	@Test
	public void leftPushIfPresentTest(){
		Long leftPush = listOperations.leftPushIfPresent("key1", "value1");
		System.out.println(JSON.toJSONString(leftPush));
	}
	
	/**
	 * @Description: Redis Lpushx 将一个或多个值插入到已存在的列表头部，列表不存在时操作无效。
	 */
	@Test
	public void rightPushIfPresentTest(){
		Long rightPush = listOperations.rightPushIfPresent("key1", "value1");
		System.out.println(JSON.toJSONString(rightPush));
	}
	
	/**
	 * @Description: Redis Rpop 命令用于移除并返回列表的最后一个元素。 
	 */
	@Test
	public void rightPopTest(){
		Object rightPop = listOperations.rightPop("key1");
		System.out.println(JSON.toJSONString(rightPop));
	}
	
	/**
	 * @Description: Redis Blpop 命令移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 */
	@Test
	public void bLeftPopTest(){
		Object leftPop = listOperations.leftPop("key1",102,TimeUnit.SECONDS);
		System.out.println(JSON.toJSONString(leftPop));
	}
	
	/**
	 * @Description: Redis Brpop 命令移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 */
	@Test
	public void bRightPopTest(){
		Object rightPop = listOperations.rightPop("key1",102,TimeUnit.SECONDS);
		System.out.println(JSON.toJSONString(rightPop));
	}
	
	/**
	 * @Description: Redis Rpoplpush 命令用于移除列表的最后一个元素，并将该元素添加到另一个列表并返回。
	 */
	@Test
	public void rightPopAndLeftPushTest(){
		Object rightPopAndLeftPush = listOperations.rightPopAndLeftPush("key1", "key2");
		System.out.println(JSON.toJSONString(rightPopAndLeftPush));
	}
	
	/**
	 * @Description: Redis Brpoplpush 命令从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 */
	@Test
	public void bRightPopAndLeftPushTest(){
		Object bRightPopAndLeftPush = listOperations.rightPopAndLeftPush("key1", "key2",100,TimeUnit.SECONDS);
		System.out.println(JSON.toJSONString(bRightPopAndLeftPush));
	}
	
	/**
	 * @Description: Redis Lindex 命令用于通过索引获取列表中的元素。
	 * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 */
	@Test
	public void indexTest(){
		Object index = listOperations.index("key1", 2);
		System.out.println(JSON.toJSONString(index));
	}
	
	/**
	 * @Description: Redis Linsert 命令用于在列表的元素前或者后插入元素。
	 *  当指定元素不存在于列表中时，不执行任何操作。
	 *  当列表不存在时，被视为空列表，不执行任何操作。
	 *  如果 key 不是列表类型，返回一个错误。
	 */
	@Test
	public void linsertTest(){
		Long leftPush = listOperations.leftPush("key1", "value1","charu");
		System.out.println(JSON.toJSONString(leftPush));
	}
	
	/**
	 * @Description: Redis Llen 命令用于返回列表的长度。
	 * 如果列表 key 不存在，则 key 被解释为一个空列表，返回 0 。
	 * 如果 key 不是列表类型，返回一个错误。
	 */
	@Test
	public void sizeTest(){
		Long size = listOperations.size("key1");
		System.out.println(JSON.toJSONString(size));
	}
	
	/**
	 * @Description:Redis Lrange 返回列表中指定区间内的元素，区间以偏移量 START 和 END 指定。
	 * 其中 0 表示列表的第一个元素， 1 表示列表的第二个元素，以此类推。
	 * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 */
	@Test
	public void rangeTest(){
		List<Object> list = listOperations.range("key1", 0, 3);
		System.out.println(JSON.toJSONString(list));
	}
	
	/**
	 * @Description:  Redis Lset 通过索引来设置元素的值。
	 * 当索引参数超出范围，或对一个空列表进行 LSET 时，返回一个错误。
	 */
	@Test
	public void setTest(){
		listOperations.set("key1", 1, "valuexx");
	}
	
	/**
	 * @Description: Redis Ltrim 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
	 * 下标 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
	 * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 */
	@Test
	public void trimTest(){
		listOperations.trim("key1", 2, 3);
	}
	
	
}
