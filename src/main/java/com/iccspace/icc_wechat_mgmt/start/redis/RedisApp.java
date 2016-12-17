package com.iccspace.icc_wechat_mgmt.start.redis;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * 是Spring Boot项目的核心注解,主要是开启自动配置 
 */  
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan  
@RestController  
// 开启缓存  
@EnableCaching  
public class RedisApp {  
      
    @Autowired  
    private DataCache dataCache;  
      
    public static void main(String[] args) {  
        SpringApplication.run(RedisApp.class, args);  
    }  
      
    @RequestMapping("/put")  
    public String put(Long id, String value) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return  sdf.format(new Date()) + " : value is " + dataCache.put(id, value) ;  
    }  
  
    @RequestMapping("/get")  
    public String query(Long id){  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return sdf.format(new Date()) + " : value is " +dataCache.query(id) ;  
    }  
      
    @RequestMapping("/remove")  
    public String remove(Long id) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        dataCache.remove(id) ;  
        return sdf.format(new Date()) + " : success " ;  
    }  
      
}