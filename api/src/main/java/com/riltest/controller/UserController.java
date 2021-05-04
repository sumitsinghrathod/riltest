package com.riltest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.riltest.model.User;
import com.riltest.request.model.UserRequest;
import com.riltest.response.model.Response;
import com.riltest.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public @ResponseBody ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest, @RequestHeader(required = true) final String key) {

		try {
			
			return userService.registerUser(userRequest);
			
		} catch (final Exception e) {
			
			return new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/userinfo/{id}")
	@ResponseBody ResponseEntity<?> getUser(@RequestHeader(required = true) final String key , @PathVariable final int id) {
		
		try {
			
			final User user = userService.findUserById(id);
			
			new ResponseEntity<>(new Response(false, "1002", user), HttpStatus.OK);
			
			return null;
		} catch (final Exception e) {
			return new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}