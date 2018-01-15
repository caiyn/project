package com.demo.platform.login.action;


import com.demo.common.action.CommonAction;
import com.demo.platform.login.bizservice.LoginBS;
import com.demo.platform.login.bizservice.impl.LoginBSImpl;
import com.demo.platform.login.domain.User;


public class LoginAC extends CommonAction {
	private LoginBS loginBS;
	private static final long serialVersionUID = 1L;
	
	private User user;
	private boolean message =true;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 用户注册
	 * @return
	 */
	public String registerUser(){
		loginBS.registerUser(user);
		return SUCCESS;
	}
	/**
	 * 用户登录跳转页面
	 * @param loginBS
	 */
	public String loginUser(){
		message = loginBS.loginUser(user);
		return SUCCESS;
	}
	public void setLoginBS(LoginBS loginBS) {
		this.loginBS = loginBS;
	}

	public boolean isMessage() {
		return message;
	}

	public void setMessage(boolean message) {
		this.message = message;
	}
	

}
