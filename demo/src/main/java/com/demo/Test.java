package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.platform.login.bizservice.LoginBS;
import com.demo.platform.login.domain.User;

public class Test {
	public static void main(String[] args){
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml"); 
		LoginBS loginBS = (LoginBS) context.getBean("loginBS");
		User user = new User();
		user.setUid("1");
		user.setUsername("lj");
//		user.setPassword("111");
//		loginBS.registerUser(user);
	}
}
