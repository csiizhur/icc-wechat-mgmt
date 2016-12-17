package com.iccspace.icc_wechat_mgmt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iccspace.icc_wechat_mgmt.start.MainApplication2;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainApplication2.class)
/*
 * @ActiveProfiles，可以指定一个或者多个profile，
 * 这样我们的测试类就仅仅加载这些名字的 profile 中定义的 bean 实例。
 * 这里激活application-prod.properties配置文件.
 */
@ActiveProfiles("prod")
public class AppTest{
	
	@Test
	public void testReg() {
		Pattern p = Pattern.compile("\\D");
		String result="cat";
    	Matcher m = p.matcher(result);
    	
    	int count=0;
    	while(m.find()){
    		count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
    	}
	}
}
