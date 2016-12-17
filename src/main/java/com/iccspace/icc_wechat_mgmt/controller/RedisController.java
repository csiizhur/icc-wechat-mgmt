package com.iccspace.icc_wechat_mgmt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iccspace.icc_wechat_mgmt.jpa.TUser;
import com.iccspace.icc_wechat_mgmt.jpa.TUserService;
import com.iccspace.icc_wechat_mgmt.service.RedisDemoService;

@RestController
@RequestMapping(path="/user")
public class RedisController {
	
	@Autowired  
	RedisDemoService demoService;  
  
    @RequestMapping("/save")  
    @ResponseBody  
    public String putCache(){  
        demoService.findUser("测试号");  
        return "ok";  
    }  
    @RequestMapping("/test2")  
    @ResponseBody  
    public String testCache(){  
    	Map<String,Object> user = demoService.findUser("测试号");  
        return "ok";  
    }
}
