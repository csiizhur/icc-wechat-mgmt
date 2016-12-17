package com.iccspace.icc_wechat_mgmt.jpa;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration
@RequestMapping(path="/user")
public class TUserController {

	@Autowired  
    TUserService userService;  
  
    @RequestMapping("/save")  
    @ResponseBody  
    public TUser putCache(String username){  
    	return userService.save(new TUser(2L, username, "111111"));  
    }  
    @RequestMapping("/able")  
    @ResponseBody  
    public TUser cacheable(Long id){  
    	return userService.findOne(new TUser(id,null,null));  
    }
    @RequestMapping("/evit")  
    @ResponseBody  
    public String evit(Long id){  
    	userService.remove(id);
    	return "ok";  
    }
}
