package com.example.devops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
class DevopsApplicationTests {
	@Value("${spring.datasource.username}")
	String username;
	@Test
	void contextLoads() {
	}
	@Test
	void dbUsernameIsSa(){
		Assertions.assertEquals("sa",username);
	}
}
