package com.demo.common.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcBaseDao extends JdbcDaoSupport {
	protected int update(String sql, Object[] params){
		return this.getJdbcTemplate().update(sql, params);
	}
	protected int queryForInt(String sql,Object[] params){
		return this.getJdbcTemplate().queryForInt(sql, params);
	}
}
