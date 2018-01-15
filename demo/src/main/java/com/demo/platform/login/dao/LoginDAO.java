package com.demo.platform.login.dao;

import com.demo.platform.login.domain.User;

public interface LoginDAO {
	//用户注册
	public void register(User user);
	public boolean userNameIfExist(User user);
	public boolean userIfExist(User user);
}
