package com.demo.admin.category.bizservice.impl;

import java.util.List;

import com.demo.admin.category.bizservice.CategoryListBS;
import com.demo.admin.category.dao.CategoryListDAO;
import com.demo.admin.category.domain.Category;

public class CategoryListBSImpl implements CategoryListBS {
	private CategoryListDAO categoryListDAO;
	
	public void setCategoryListDAO(CategoryListDAO categoryListDAO) {
		this.categoryListDAO = categoryListDAO;
	}

	/**
	 * 查询初始化分类管理的列表数据
	 */
	@Override
	public List<Category> queryCategoryList() {
		// TODO Auto-generated method stub
		return categoryListDAO.queryCategoryList();
	}

}
