package com.iccspace.icc_wechat_mgmt.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
@EnableAutoConfiguration
@RequestMapping(path="/user")
public class TestController {

	//@Autowired
	//private UserService userService;
	
	//@RequestMapping(value = "/test", method = RequestMethod.GET)
	//@RequestMapping("/getUser")
	//@ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
	//public User getUsers() {
		//User user=new User();
		//user.setUserId("qwe");
		//user.setNickName("luu");
		//return user;
	//}
	/*@RequestMapping("/likeName")
	@ExceptionHandler({SQLException.class,DataAccessException.class})
    public List<User> likeName(String name){
			PageHelper.startPage(1,1);
           return userService.likeName(name);
    }*/
}
