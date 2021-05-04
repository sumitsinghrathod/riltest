package com.riltest.service;

import org.springframework.http.ResponseEntity;

import com.riltest.model.Machine;
import com.riltest.request.model.AssetRequest;

public interface MachineService {
	
	public ResponseEntity<?> addMachine(final AssetRequest assetRequest);
	
	public Machine validateMachineReq(final AssetRequest assetRequest);
	
	public Machine save(final Machine machine);
	
	public ResponseEntity<?> updateMachine(final AssetRequest assetRequest);
	
	public Machine findById(final int id);

	public ResponseEntity<?> deleteMachine(final int id);
	
	public int deleteById(final int id);
}
