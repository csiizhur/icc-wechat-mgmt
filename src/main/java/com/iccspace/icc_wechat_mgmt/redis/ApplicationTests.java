package com.iccspace.icc_wechat_mgmt.redis;

import javax.annotation.Resource;

//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iccspace.icc_wechat_mgmt.start.MainApplication;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(MainApplication.class)
public class ApplicationTests {

    @Autowired
	//@Resource
    private StringRedisTemplate stringRedisTemplate;

	//@Resource
	//private RedisTemplate<String, User> redisTemplate;
	
    //@Test
    public void test() throws Exception {

        // 保存字符串
    	RedisConnectionFactory f=stringRedisTemplate.getConnectionFactory();
    	RedisConnection c=f.getConnection();
    	c.getClientName();
        stringRedisTemplate.opsForValue().set("aaa", "111");
       // Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
        //User u=redisTemplate.opsForValue().get("超人");
        //redisTemplate.opsForList().remove("超人", -1, null);
        //redisTemplate.delete("超人");
        //redisTemplate.delete("蝙蝠侠");
        //redisTemplate.delete("蜘蛛侠");
    }
    
    //@Test
    public void testObject() throws Exception {

        // 保存对象
        //User user = new User("超人", "20");
        //redisTemplate.opsForValue().set(user.getUserId(), user);

        //Assert.assertEquals("20", redisTemplate.opsForValue().get("超人").getNickName());
        

    }

}