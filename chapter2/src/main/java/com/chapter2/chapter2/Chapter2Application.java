package com.chapter2.chapter2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chapter2.chapter2.myBatis.mapper.ProductCategoryMapper")
public class Chapter2Application {
	public static void main(String[] args) {
		SpringApplication.run(Chapter2Application.class, args);
	}
}