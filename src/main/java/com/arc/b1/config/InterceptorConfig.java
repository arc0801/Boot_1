package com.arc.b1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.arc.b1.interceptor.CustomInterceptor;
import com.arc.b1.interceptor.MemberInterceptor;

@Configuration //XML 파일입니담!! JSP 아니야....
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private CustomInterceptor customInterceptor;
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//Interceptor 등록
		registry.addInterceptor(customInterceptor)
		
		//Interceptor를 사용할 URL 패턴 등록
		.addPathPatterns("/member/*")
		//.addPathPatterns("/member/memberPage");
		
		//Interceptor를 제외할 URL 패턴 등록
		.excludePathPatterns("/member/memberLogin")
		.excludePathPatterns("/member/memberJoin");
		
		
		registry.addInterceptor(memberInterceptor)
		.addPathPatterns("/member/memberPage");
		
		//WebMvcConfigurer.super.addInterceptors(registry); //생략해도 무방
	}
}