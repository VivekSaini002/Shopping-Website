package com.ecommerce.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.ecommerce.model.UserDetl;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;
import com.ecommerce.util.AppConstant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String email = request.getParameter("username");
		
		UserDetl userDetl = userRepository.findByEmail(email);
		
		if(userDetl != null) {
			if(userDetl.getIsEnable()) {
				if(userDetl.isAccountNonLocked()) {
					if(userDetl.getFailedAttempt() < AppConstant.ATTEMPT_TIME) {
						userService.increaseFailedAttempt(userDetl);
						
					} else {
						userService.userAccountLock(userDetl);
						exception = new LockedException("Your account is locked! Failed attempt 3");
					}
				} else {
					if(userService.unlockAccountTimeExpired(userDetl)) {
						exception = new LockedException("Your account is unlocked! Please try to login!");
					} else {
						exception = new LockedException("Your account is locked! Please try after sometimes!");
					} 
				}
				
			} else {
				exception = new LockedException("Your account is inactive!");
			}
			
		}  else {
			exception = new LockedException("Email & password invalid");
		}
		
		super.setDefaultFailureUrl("/signin?error");
		
		super.onAuthenticationFailure(request, response, exception);
	}

}
