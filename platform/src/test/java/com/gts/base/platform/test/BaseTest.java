package com.gts.base.platform.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml"})
public class BaseTest {
	
	/**
	 * @Fields redisTemplate : KEY操作
	 */ 
	@Autowired
	public RedisTemplate<String,Object> redisTemplate;

	/**
	 * @Fields valueOperations : 字符串(String)操作
	 */ 
	public ValueOperations<String,Object> valueOperations;
	
	/**
	 * @Fields hashOperations : 哈希(Hash)操作
	 */ 
	public HashOperations<String,String,Object> hashOperations;
	
	/**
	 * @Fields setOperations : 集合(Set)操作
	 */ 
	public SetOperations<String,Object> setOperations;
	
	/**
	 * @Fields zSetOperations : 有序集合(sorted set)操作
	 */ 
	public ZSetOperations<String,Object> zSetOperations;
	
	/**
	 * @Fields listOperations : 列表(List)操作
	 */ 
	public ListOperations<String,Object> listOperations;
	
	@Before
	public void setup() {
		valueOperations = redisTemplate.opsForValue();
		hashOperations = redisTemplate.opsForHash();
		setOperations = redisTemplate.opsForSet();
		zSetOperations = redisTemplate.opsForZSet();
		listOperations = redisTemplate.opsForList();
	}
}
