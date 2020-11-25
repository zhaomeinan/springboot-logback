package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * description： TODO
 * @author: zhaomeinan
 * date: 2018/6/20 10:59
 */
@ComponentScan(basePackages = { "com.example" })
@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		int i=1;
		i=2;
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
