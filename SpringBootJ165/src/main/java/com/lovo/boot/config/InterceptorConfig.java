package com.lovo.boot.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lovo.boot.util.PowerInterceptor;

@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	//添加多个拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		//注册权限的拦截器
		registry.addInterceptor(new PowerInterceptor()).addPathPatterns("/**");
	}

	//静态资源的放行
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
   
		registry.addResourceHandler("/staticResources/**")//放行的资源
		.addResourceLocations("classpath:/staticResources/"); //资源所在本地位置
		
		registry.addResourceHandler("/templates/**")//放行的资源
		.addResourceLocations("classpath:/templates/"); //资源所在本地位置
	}

	
	
}
