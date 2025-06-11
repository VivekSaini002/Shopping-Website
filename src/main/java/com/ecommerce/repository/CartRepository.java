package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.ecommerce.model.Cart;
import com.ecommerce.model.UserDetl;

import jakarta.transaction.Transactional;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public Cart findByProductIdAndUserId(int productId, int userId);

	public int countByUserId(int userId);

	public List<Cart> findByUserId(int userId);
	
	@Transactional
	@Modifying
	public void deleteByUser(UserDetl user);


}
