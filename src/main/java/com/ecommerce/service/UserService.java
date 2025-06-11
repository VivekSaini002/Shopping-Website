package com.ecommerce.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.UserDetl;

public interface UserService {
	
    public UserDetl saveUser(UserDetl userDetl);
	
//	public List<UserDetl> getAllUserDetl();
	
//	public boolean deleteUserDetl(int id);
    
    public UserDetl getUserByEmail(String email);
    
    public List<UserDetl> getUsers(String role);

	public boolean updateAccountStatus(int id, boolean status);
	
	public void increaseFailedAttempt(UserDetl user);
	
	public void userAccountLock(UserDetl user);
	
	public boolean unlockAccountTimeExpired(UserDetl user);
	
	public void resetAttempt(int userId);

	public void updateUserResetToken(String email, String resetToken);
	
	public UserDetl getUserByToken(String token);

	public UserDetl updateUser(UserDetl user);

	UserDetl updateUserProfile(UserDetl user, MultipartFile img);
	
	public UserDetl saveAdmin(UserDetl user);

	public Boolean existsEmail(String email);

		

}
