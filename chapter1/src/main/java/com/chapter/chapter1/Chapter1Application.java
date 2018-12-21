package com.chapter.chapter1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Chapter1Application /*extends SpringBootServletInitializer*/ {
//	war 打包
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(Chapter1Application.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter1Application.class, args);
	}
}
