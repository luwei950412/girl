package com.luwei.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class GirlApplication {


	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);
	}

//	// 重写方法
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(applicationClass);
//	}
//
//	private static Class applicationClass = GirlApplication.class;

}
