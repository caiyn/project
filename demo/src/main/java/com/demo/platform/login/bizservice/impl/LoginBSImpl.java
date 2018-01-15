package com.demo.platform.login.bizservice.impl;

import com.demo.platform.login.bizservice.LoginBS;
import com.demo.platform.login.dao.LoginDAO;
import com.demo.platform.login.domain.User;

public class LoginBSImpl implements LoginBS {
	private LoginDAO loginDAO;
	/**
	 * 用户注册
	 */
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		/**
		 * 首先判断该用户在数据库中是否存在,只有不存在才能注册
		 */
		if(!loginDAO.userNameIfExist(user)){
			loginDAO.register(user);
		}
	}
	/**
	 * 用户登录
	 */
	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		return loginDAO.userIfExist(user);
	}
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	

}
