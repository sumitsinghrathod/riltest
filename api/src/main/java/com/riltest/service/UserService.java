package com.riltest.service;

import org.springframework.http.ResponseEntity;

import com.riltest.model.User;
import com.riltest.request.model.UserRequest;

public interface UserService {
	
	public User save(final User user);
	
	public ResponseEntity<?> registerUser(final UserRequest userRequest);
	
	public User isUserReqValid(final UserRequest userRequest);
	
	public User findUserById(final int id);
	
	public ResponseEntity<?> login(User user);
	
	public String generateToken(final String email);

}
