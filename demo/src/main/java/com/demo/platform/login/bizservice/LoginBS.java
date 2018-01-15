package com.demo.platform.login.bizservice;

import com.demo.platform.login.domain.User;

public interface LoginBS {
	//用户注册
	public void registerUser(User user);
	//用户登录
	public boolean loginUser(User user);
}
