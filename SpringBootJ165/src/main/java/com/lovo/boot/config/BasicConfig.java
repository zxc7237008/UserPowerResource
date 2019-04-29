package com.lovo.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lovo.boot.bean.UserBean;

//spring启动的时候运行它，相当于spring上下文
@Configuration
public class BasicConfig {

	public BasicConfig(){
		System.out.println("。。。。。。。。。。构造方法被执行");
	}

	//相当于xml里面的bean 标签
	@Bean(value="userBean")
	public UserBean getUserBean(){
		UserBean user=new UserBean();
		user.setUserId("12345");
		user.setUserName("赵云");
		return user;
	}
}
