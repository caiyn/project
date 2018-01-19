package com.demo.common.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.demo.common.domain.Pagination;


public class JdbcBaseDao extends JdbcDaoSupport {
	protected int update(String sql, Object[] params){
		return this.getJdbcTemplate().update(sql, params);
	}
	protected int queryForInt(String sql,Object[] params){
		return this.getJdbcTemplate().queryForInt(sql, params);
	}
	protected int queryForInt(String sql){
		return this.getJdbcTemplate().queryForInt(sql);
	}
	protected List query(String sql,RowMapper rowMapper,Pagination pagination){
		int totalCount = 0;
		if(checkPagination(pagination)){
			totalCount = queryForInt("SELECT COUNT(1) FROM ("+sql+") s");
//			sql = new StringBuffer("SELECT * FROM ( SELECT T.*, ROWNUM NUM FROM (").append(sql).append(
//			") T WHERE ROWNUM <= ").append(pagination.getStart() + pagination.getLimit()).append(
//			" ) TT  WHERE TT.NUM > ").append(pagination.getStart()).toString();
			sql = "SELECT *FROM ("+sql+") a limit "+pagination.getStart()+" ,"+pagination.getLimit()+"";
			pagination.setTotal(totalCount);
		}
		return this.getJdbcTemplate().query(sql, rowMapper);
	}
	private boolean checkPagination(Pagination p) {
		return p != null && p.getStart() >= 0 && p.getLimit() >= 0;
	}
}
