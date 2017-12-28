package com.demo.platform.login.bizservice.impl;

import com.demo.platform.login.bizservice.LoginBS;
import com.demo.platform.login.dao.LoginDAO;
import com.demo.platform.login.domain.User;

public class LoginBSImpl implements LoginBS {
	private LoginDAO loginDAO;
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		loginDAO.register(user);
	}
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

}
