package com.demo.admin.category.action;

import java.util.ArrayList;
import java.util.List;

import com.demo.admin.category.bizservice.CategoryListBS;
import com.demo.admin.category.domain.Category;
import com.demo.common.action.CommonAction;
import com.demo.common.domain.Pagination;

public class CategoryListAC extends CommonAction{
	private CategoryListBS categoryListBS;
	private List<Category> categoryList = new ArrayList<Category>();
	private int start;
	private int limit;
	private boolean checkScroll = false;
	private int totalCount;
	public String initLoadCategoryList(){
		Pagination pagination = new Pagination();
		pagination.setStart(start);
		pagination.setLimit(limit);
		categoryList = categoryListBS.queryCategoryList(pagination);
		totalCount = pagination.getTotal();
		checkScroll = pagination.getStart()+pagination.getLimit()<pagination.getTotal();
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

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public boolean isCheckScroll() {
		return checkScroll;
	}

	public int getTotalCount() {
		return totalCount;
	}

}
