package com.demo.platform.login.dao.impl;

import com.demo.common.dao.JdbcBaseDao;
import com.demo.platform.login.dao.LoginDAO;
import com.demo.platform.login.domain.User;

public class LoginDAOImpl extends JdbcBaseDao implements LoginDAO {
	/**
	 * 注册用户
	 */
	private static String CREATE_USER = "INSERT INTO USER(id,username,password) VALUES(?,?,?) ";
	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		user.setUid(com.demo.common.util.IDGenerator.generateId());
		this.executeUpdate(CREATE_USER, new Object[]{user.getUid(),user.getUsername(),user.getPassword()});
	}

}
