package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.admin.category.dao.CategoryListDAO;

public class Test {
	public static void main(String[] args){
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml"); 
		CategoryListDAO CategoryListDao = (CategoryListDAO) context.getBean("categoryListDAO");
//		User user = new User();
//		user.setUid("1");
//		user.setUsername("lj");
//		user.setPassword("111");
//		loginBS.registerUser(user);
		CategoryListDao.queryCategoryList();
	}
}
