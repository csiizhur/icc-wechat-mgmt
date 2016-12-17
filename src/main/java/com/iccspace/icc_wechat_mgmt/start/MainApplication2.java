package com.iccspace.icc_wechat_mgmt.start;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.iccspace.icc_wechat_mgmt.service.SendMessage;
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MainApplication2 extends  WebMvcConfigurationSupport implements EmbeddedServletContainerCustomizer {
	
	/**
     * 1、 extends WebMvcConfigurationSupport
     * 2、重写下面方法;
     * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
     * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
     */
	@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false)
                   .setUseTrailingSlashMatch(true);
    }
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8896);	
	}
	/*public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(MainApplication2.class, args);
		String[] names = context.getBeanDefinitionNames();  
        Arrays.sort(names);
        for (String string : names) {  
        	System.err.println(string);
        }
	}*/
}
