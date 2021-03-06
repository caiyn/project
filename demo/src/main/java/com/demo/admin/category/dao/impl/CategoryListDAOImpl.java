package com.demo.admin.category.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.demo.admin.category.dao.CategoryListDAO;
import com.demo.admin.category.domain.Category;
import com.demo.common.dao.JdbcBaseDao;
import com.demo.common.domain.Pagination;

public class CategoryListDAOImpl extends JdbcBaseDao implements CategoryListDAO {
	private static final  String QUERY_CATEGORYLIST_SQL = "SELECT * FROM category";
	private class CategoryRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Category category = new Category();
			category.setId(rs.getString("ID"));
			category.setCategoryImg(rs.getString("IMG"));
			category.setCategoryName(rs.getString("CATEGORYNAME"));
			return category;
		}
		
	}
	/**
	 * 初始化查询分类管理列表数据
	 */
	@Override
	public List<Category> queryCategoryList(Pagination pagination) {
		// TODO Auto-generated method stub
		List<Category> categoryList = this.query(QUERY_CATEGORYLIST_SQL, new CategoryRowMapper(),pagination);
		return categoryList;
	}
}
