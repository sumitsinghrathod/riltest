package com.riltest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riltest.machine.repository.MachineRepository;
import com.riltest.model.Machine;
import com.riltest.request.model.AssetRequest;
import com.riltest.response.model.Response;
import com.riltest.service.MachineService;
import com.riltest.util.DataValidation;
import com.riltest.util.LogConstant;
import com.riltest.util.ResponseCode;

@Service
public class MachineServiceImpl implements MachineService {
	
	final Logger logger = LoggerFactory.getLogger(MachineServiceImpl.class);
	
	private final MachineRepository machineRepository;
	
	@Autowired
	public MachineServiceImpl(MachineRepository machineRepository) {
		this.machineRepository = machineRepository;
	}

	/**
	 * This method will add the machine 
	 * @param assetRequest
	 * @return {@link ResponseEntity}
	 */
	@Override
	public ResponseEntity<?> addMachine(final AssetRequest assetRequest) {
		
		try {
			
			// Validate Machine Object
			final Machine machineObj = validateMachineReq(assetRequest);
			// Return error response if request validation failed
			if (null == machineObj) {
				
				return new ResponseEntity<>(new Response(false, ResponseCode.ERROR_RESPONSE, null), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			// Save Machine Object
			final Machine machine = save(machineObj);
			// Return response
			return null != machine ? new ResponseEntity<>(new Response(true, ResponseCode.SUCCESS_RESPONSE, machine), HttpStatus.OK)
					: new ResponseEntity<>(new Response(false, ResponseCode.ERROR_RESPONSE, null), HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return new ResponseEntity<>(new Response(false, ResponseCode.ERROR_RESPONSE, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This method will validate the machine request 
	 * @param assetRequest
	 * @return {@link Machine}
	 */
	@Override
	public Machine validateMachineReq(final AssetRequest assetRequest) {
		
		try {
			
			//Validate request
			if (DataValidation.isStringEmpty(assetRequest.getMachineName()) || DataValidation.isStringEmpty(assetRequest.getMachineType())) {
				logger.error(LogConstant.INVALID_MACHINE_REQUEST);
				return null;
			}
			// Return Machine Object
			return new Machine(assetRequest.getId() ,assetRequest.getMachineName(), assetRequest.getMachineType(),
					assetRequest.getMoneyCollected(), assetRequest.getItemRefilled(),
					assetRequest.getIsServiceRequired(), assetRequest.getUserId());
			
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return null;
		}
	}

	/**
	 * This method will save the machine object 
	 * @param assetRequest
	 * @return {@link Machine}
	 */
	@Override
	public Machine save(final Machine machine) {
		try {
			return machineRepository.save(machine);
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return null;
		}
	}

	/**
	 * This method will update the machine 
	 * @param assetRequest
	 * @return {@link ResponseEntity}
	 */
	@Override
	public ResponseEntity<?> updateMachine(final AssetRequest assetRequest) {
		
		try {
			// Validate Machine Request
			if (DataValidation.isStringEmpty(assetRequest.getMachineName()) || DataValidation.isStringEmpty(assetRequest.getMachineType())) {
				logger.error(LogConstant.INVALID_MACHINE_REQUEST);
				return new ResponseEntity<>(new Response(false, ResponseCode.ERROR_RESPONSE, null), HttpStatus.BAD_REQUEST);
			} 
			// Find Machine by Id
			final Machine machineObj = findById(assetRequest.getId());
			// Verify NULL
			if (null == machineObj) {
				logger.error(LogConstant.MACHINE_NOT_FOUND ,  assetRequest.getId());
				return new ResponseEntity<>(new Response(false, ResponseCode.ERROR_RESPONSE, null), HttpStatus.BAD_REQUEST);
			}
			// Update Machine Object
			machineObj.setIsServiceRequired(assetRequest.getIsServiceRequired());
			machineObj.setItemRefilled(assetRequest.getItemRefilled());
			machineObj.setMachineName(assetRequest.getMachineName());
			machineObj.setMachineType(assetRequest.getMachineType());
			machineObj.setMoneyCollected(assetRequest.getMoneyCollected());
			// Save machine object
			final Machine machine = save(machineObj);
			// Return error response if failed to save the object
			if (null == machine) {
				logger.error(LogConstant.FAILED_TO_UPDATE_MACHINE_INFO , assetRequest.getId());
				return new ResponseEntity<>(new Response(false, ResponseCode.ERROR_RESPONSE, null), HttpStatus.BAD_REQUEST);
			}
			// Success Response
			return new ResponseEntity<>(new Response(true, ResponseCode.SUCCESS_RESPONSE, machine), HttpStatus.OK);
			
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return new ResponseEntity<>(new Response(false, ResponseCode.ERROR_RESPONSE, null), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

	@Override
	public Machine findById(final int id) {
		
		try {
			
			return machineRepository.findById(id).get();
			
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return null;
		}
	}

	@Override
	public ResponseEntity<?> deleteMachine(final int id) {
		
		try {
				return 1 == deleteById(id) ? new ResponseEntity<>(new Response(true, "1001", null), HttpStatus.OK) : new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.BAD_REQUEST);
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION , e);
			return new ResponseEntity<>(new Response(false, "1001", null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public int deleteById(final int id) {
		
		try {
			machineRepository.deleteById(id);
			return 1;
			
		} catch (final Exception e) {
			logger.error(LogConstant.EXCEPTION ,e);
			return 0;
		}
	}

}
