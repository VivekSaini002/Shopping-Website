package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Category;

public interface CategoryRepositoy extends JpaRepository<Category, Integer> {
	
	public boolean existsByName(String name);

	public List<Category> findByIsActiveTrue();

}
	