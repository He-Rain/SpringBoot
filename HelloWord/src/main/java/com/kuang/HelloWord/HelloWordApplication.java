package com.kuang.HelloWord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//本身就是spring的一个组件
@ComponentScan(basePackages={"com.kuang.*"})  //扫描包路径
@SpringBootApplication
public class HelloWordApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWordApplication.class, args);
	}

}
