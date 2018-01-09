package com.demo.platform.login.action;


import com.demo.common.action.CommonAction;
import com.demo.platform.login.bizservice.LoginBS;
import com.demo.platform.login.domain.User;


public class LoginAC extends CommonAction {
	private LoginBS loginBS;
	private static final long serialVersionUID = 1L;
	
	private User user;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String registerUser(){
		loginBS.registerUser(username,password);
		return SUCCESS;
	}
//	public String execute(){
//		loginBS.registerUser(user);
//		return SUCCESS;
//	}
	
	public void setLoginBS(LoginBS loginBS) {
		this.loginBS = loginBS;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
