package com.kuang;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot06DataApplicationTests {
@Resource
//@Autowired
//@Qualifier("dataSource")
	DataSource dataSource;
	@Test
	void contextLoads() throws SQLException {
		//查看默认的数据源//class com.zaxxer.hikari.HikariDataSource  :dbcp springboot框架的默认数据源。
		System.out.println(dataSource.getClass());
		//获取数据库连接
	Connection connection =dataSource.getConnection();
		System.out.println("Info===>"+connection);
		connection.close();
	}

}
