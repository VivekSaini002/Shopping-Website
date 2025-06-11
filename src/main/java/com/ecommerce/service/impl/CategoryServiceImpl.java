package com.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ecommerce.model.Category;
import com.ecommerce.repository.CategoryRepositoy;
import com.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepositoy categoryRepositoy;

	@Override
	public Category saveCategory(Category category) {
		return categoryRepositoy.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepositoy.findAll();
	}

	@Override
	public boolean existCategory(String name) {
		return categoryRepositoy.existsByName(name);
	}

	@Override
	public boolean deleteCategory(int id) {
		Category category = categoryRepositoy.findById(id).orElse(null);
		if(!ObjectUtils.isEmpty(category)) {
			categoryRepositoy.delete(category);
			return true;
		}
		return false;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = categoryRepositoy.findById(id).orElse(null);
		return category;
	}

	@Override
	public List<Category> getAllActiveCategory() {
		List<Category> categories = categoryRepositoy.findByIsActiveTrue();
		return categories;
	}

	@Override
	public Page<Category> getAllCategorPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return categoryRepositoy.findAll(pageable);
	}
}
