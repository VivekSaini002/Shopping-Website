package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Cart;

public interface CartService {
	
	public Cart saveCart(int productId, int userId);
	
	public List<Cart> getCartsByUser(int userId);
	
	public int getCountCart(int userId);

	public void updateQuantity(String sy, Integer cid);

}
