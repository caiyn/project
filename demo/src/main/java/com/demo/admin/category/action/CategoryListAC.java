package com.demo.admin.category.action;

import java.util.ArrayList;
import java.util.List;

import com.demo.admin.category.bizservice.CategoryListBS;
import com.demo.admin.category.domain.Category;
import com.demo.common.action.CommonAction;

public class CategoryListAC extends CommonAction{
	private CategoryListBS categoryListBS;
	private List<Category> categoryList = new ArrayList<Category>();

	public String initLoadCategoryList(){
		categoryList = categoryListBS.queryCategoryList();
		return SUCCESS;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public void setCategoryListBS(CategoryListBS categoryListBS) {
		this.categoryListBS = categoryListBS;
	}
}
