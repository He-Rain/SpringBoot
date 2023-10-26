package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication  标注了这个类是一个springboot的一个应用,启动类下的所有资源被导入
@SpringBootApplication
public class Springboot01HellowordApplication {

	public static void main(String[] args) {
		//将springboot应用启动
		SpringApplication.run(Springboot01HellowordApplication.class, args);
	}

}
