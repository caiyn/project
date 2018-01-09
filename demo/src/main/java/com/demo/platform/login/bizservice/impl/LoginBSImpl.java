package com.demo.platform.login.bizservice.impl;

import com.demo.platform.login.bizservice.LoginBS;
import com.demo.platform.login.dao.LoginDAO;
import com.demo.platform.login.domain.User;

public class LoginBSImpl implements LoginBS {
	private LoginDAO loginDAO;
	@Override
	public void registerUser(String username,String password) {
		// TODO Auto-generated method stub
		loginDAO.register(username,password);
	}
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

}
