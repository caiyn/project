package com.demo.platform.login.dao.impl;

import com.demo.common.dao.JdbcBaseDao;
import com.demo.platform.login.dao.LoginDAO;
import com.demo.platform.login.domain.User;

public class LoginDAOImpl extends JdbcBaseDao implements LoginDAO {
	/**
	 * 注册用户
	 */
	private static String CREATE_USER = "INSERT INTO USER(id,username,password) VALUES(?,?,?) ";
	/**
	 * 判断用户是否存在，查询用户id
	 */
	private static String IF_USERNAME_EXIST = "SELECT COUNT(1) FROM USER WHERE username=?";
	/**
	 * 判断登录的用户名和密码是否正确
	 */
	private static String IF_USER_EXIST = "SELECT COUNT(1) FROM USER WHERE username=? and password=?";
	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		user.setUid(com.demo.common.util.IDGenerator.generateId());
//		String id = com.demo.common.util.IDGenerator.generateId();
		this.update(CREATE_USER, new Object[]{user.getUid(),user.getUsername(),user.getPassword()});
	}
	/**
	 * 判断该用户是否在数据库中已经存在
	 */
	@Override
	public boolean userNameIfExist(User user) {
		// TODO Auto-generated method stub
		int num = this.queryForInt(IF_USERNAME_EXIST, new Object[]{user.getUsername()});
		//如果为false则证明数据库中不存在此用户
		if(num==0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 判断用户名和密码是否正确
	 */
	@Override
	public boolean userIfExist(User user) {
		// TODO Auto-generated method stub
		int num = this.queryForInt(IF_USER_EXIST, new Object[]{user.getUsername(),user.getPassword()});
		//如果为false则证明数据库中不存在与之对应的用户名和密码，证明用户名和密码不对
		if(num==0){
			return false;
		}else{
			return true;
		}
	}

}
