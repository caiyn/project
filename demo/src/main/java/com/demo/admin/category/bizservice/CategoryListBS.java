package com.demo.admin.category.bizservice;

import java.util.List;

import com.demo.admin.category.domain.Category;
import com.demo.common.domain.Pagination;

public interface CategoryListBS {
	public List<Category> queryCategoryList(Pagination pagination);
}
