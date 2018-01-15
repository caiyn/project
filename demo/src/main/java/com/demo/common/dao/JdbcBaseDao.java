package com.demo.common.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcBaseDao extends JdbcDaoSupport {
	protected int update(String sql, Object[] params){
		return this.getJdbcTemplate().update(sql, params);
	}
	protected int queryForInt(String sql,Object[] params){
		return this.getJdbcTemplate().queryForInt(sql, params);
	}
	protected List query(String sql,RowMapper rowMapper){
		return this.getJdbcTemplate().query(sql, rowMapper);
	}
}
