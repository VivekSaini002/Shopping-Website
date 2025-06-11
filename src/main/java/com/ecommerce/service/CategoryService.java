package com.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ecommerce.model.Category;

public interface CategoryService {
	
	public Category saveCategory(Category category);
	
	public boolean existCategory(String name);
	
	public List<Category> getAllCategory();
	
	public boolean deleteCategory(int id);
	
	public Category getCategoryById(int id);
	
	public List<Category> getAllActiveCategory();
	
	public Page<Category> getAllCategorPagination(Integer pageNo,Integer pageSize);

}
