package com.riltest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riltest.model.User;
import com.riltest.request.model.UserRequest;
import com.riltest.response.model.Response;
import com.riltest.service.UserService;
import com.riltest.user.repository.UserRepository;
import com.riltest.util.DataValidation;
import com.riltest.util.LogConstant;

@Service
public class UserServiceImpl implements UserService {
	
	final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ElasticsearchOperations elasticSearchTemplateBean;


	/**
	 * This method will return boolean true if user request validated or else false
	 * @param UserRequest
	 * @return boolean
	 */
	@Override
	public User isUserReqValid(final UserRequest userRequest) {
		
		try {
			
			if (null == userRequest || DataValidation.isStringEmpty(userRequest.getEmail())
					|| DataValidation.isStringEmpty(userRequest.getFirstName())
					|| DataValidation.isStringEmpty(userRequest.getUserType())) {

				logger.error(LogConstant.INVALID_USER_REQUEST);
				return null;
			}
			
			return new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(),
					userRequest.getUserType());
		} catch (final Exception e) {
			
			return null;
		}
	}

	/**
	 * This method returns User Object for id
	 * @param id
	 * @return User
	 */
	@Override
	public User findUserById(final int id) {
		
		try {
			return userRepository.findById(id).get();
			
		} catch (final Exception e) {
			return null;
		}
	}

	/**
	 * This method returns user object once saved
	 * @param user
	 * @return User
	 */
	@Override
	public User save(final User user) {
		try {
			
			return userRepository.save(user);
			
		} catch (final Exception e) {
			return null;
		}
	}

	/**
	 * This method return response of user registeration. 
	 * @param userRequest
	 * @return ResponseEntity
	 */
	@Override
	public ResponseEntity<?> registerUser( final UserRequest userRequest) {
		
		try {

			final User user = isUserReqValid(userRequest);
			if (null == user) {

				new ResponseEntity<>(new Response(false, "1000", null), HttpStatus.BAD_REQUEST);
			}

			final User userObj = save(user);
			if (null == userObj) {
				logger.info(LogConstant.FAILED_TO_REG_USER , user.getEmail());
				new ResponseEntity<>(new Response(false, "1002", null), HttpStatus.INTERNAL_SERVER_ERROR);

			} else {

				return new ResponseEntity<>(new Response(true, "1001", userObj), HttpStatus.OK);
			}

			return new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.BAD_REQUEST);

		} catch (final Exception e) {

			return new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> login(final User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateToken(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
