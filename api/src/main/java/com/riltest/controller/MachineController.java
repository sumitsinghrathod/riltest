package com.riltest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.riltest.request.model.AssetRequest;
import com.riltest.response.model.Response;
import com.riltest.service.MachineService;
import com.riltest.util.LogConstant;

@RestController
@RequestMapping("/machine")
@ResponseBody
public class MachineController {
	
	final Logger logger = LoggerFactory.getLogger(MachineController.class);
	
	@Autowired
	private MachineService machineService;
	
	/**
	 * This API will add the machine and it will return ResponseEntity object in response
	 * @param assetRequest
	 * @param token
	 * @return
	 */
	@PostMapping("/addmachine")
	public ResponseEntity<?> addMachine(@RequestBody(required = true) AssetRequest assetRequest , @RequestHeader(required = true) final String token) {
		
		try {
			// Return response of addMachine 
			return machineService.addMachine(assetRequest);
			
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API will update the machine and it will return ResponseEntity object in response
	 * @param assetRequest
	 * @param token
	 * @return
	 */
	@PutMapping("/updatemachine")
	public ResponseEntity<?> updateMachine(@RequestBody(required = true) AssetRequest assetRequest , @RequestHeader(required = true) final String token) {
		
		try {
			// Return Response of Update Machine
			return machineService.updateMachine(assetRequest);
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This API will delete the machine and it will return ResponseEntity object in response
	 * @param id
	 * @param token
	 * @return
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteMachine(@PathVariable(required = true) final int id,@RequestHeader(required = true) final String token) {
		
		try {
			// Return response of delete machine
			return machineService.deleteMachine(id);
			
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
