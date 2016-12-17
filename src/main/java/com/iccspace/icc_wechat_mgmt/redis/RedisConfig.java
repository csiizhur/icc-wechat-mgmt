package com.iccspace.icc_wechat_mgmt.redis;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration  
@EnableCaching  
public class RedisConfig extends CachingConfigurerSupport{  
  
    @Bean  
    public KeyGenerator wiselyKeyGenerator(){  
        return new KeyGenerator() {  
            @Override  
            public Object generate(Object target, Method method, Object... params) {  
                StringBuilder sb = new StringBuilder();  
                sb.append(target.getClass().getName());  
                sb.append(method.getName());  
                for (Object obj : params) {  
                    sb.append(obj.toString());  
                }  
                return sb.toString();  
            }  
        };  
  
    }  
  
    @Bean  
    public CacheManager cacheManager(  
            @SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
    	RedisCacheManager manage=new RedisCacheManager(redisTemplate);
    	
    	manage.setDefaultExpiration(1000L);
    	//manage.setExpires(new HashMap<String,Long>());
        return manage;  
    }  
  
    @Bean  
    public RedisTemplate<String, String> redisTemplate(  
            RedisConnectionFactory factory) {  
        StringRedisTemplate template = new StringRedisTemplate(factory);  
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);  
        ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        template.setValueSerializer(jackson2JsonRedisSerializer);  
        template.afterPropertiesSet();  
        return template;  
    }
    
    /*@Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, User> redisObjectTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }*/
}