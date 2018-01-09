package com.demo.platform.login.action;


import com.demo.common.action.CommonAction;
import com.demo.platform.login.bizservice.LoginBS;
import com.demo.platform.login.domain.User;


public class LoginAC extends CommonAction {
	private LoginBS loginBS;
	private static final long serialVersionUID = 1L;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String registerUser(){
		loginBS.registerUser(user);
		return SUCCESS;
	}
//	public String execute(){
//		loginBS.registerUser(user);
//		return SUCCESS;
//	}

	public void setLoginBS(LoginBS loginBS) {
		this.loginBS = loginBS;
	}
	

}
