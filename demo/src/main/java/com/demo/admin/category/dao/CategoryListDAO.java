package com.demo.admin.category.dao;

import java.util.List;

import com.demo.admin.category.domain.Category;
import com.demo.common.domain.Pagination;

public interface CategoryListDAO {
	public List<Category> queryCategoryList(Pagination pagination);
}
