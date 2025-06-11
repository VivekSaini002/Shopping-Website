package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.UserDetl;

public interface UserRepository extends JpaRepository<UserDetl, Integer> {

	public UserDetl findByEmail(String email);

	public List<UserDetl> findByRole(String role);

	public UserDetl findByResetToken(String token);
	
	public Boolean existsByEmail(String email);
	
}
	