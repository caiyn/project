package com.demo.common.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcBaseDao extends JdbcDaoSupport {
	protected int executeUpdate(String sql, Object[] params){
		return this.getJdbcTemplate().update(sql, params);
	}
}
