package com.riltest.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.riltest.machine.repository.MachineRepository;
import com.riltest.model.Machine;
import com.riltest.service.impl.MachineServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MachineServiceImplTest {
	
	@Mock
	private MachineRepository machineRepository;
	
	@Mock
	private MachineService machineService;
	
	@Test
	@DisplayName("This method is to fetch machine Object")
	void testFindById() {
		
		final MachineServiceImpl machineServiceImpl = new MachineServiceImpl(machineRepository);
		final Machine machine = new Machine(1, "coffe", "electric", "500", "yes", "no", 1);
		
		Mockito.when(machineRepository.findById(1)).thenReturn(Optional.of(machine));
		
		final Machine machineObj = machineServiceImpl.findById(1);
		
		Assertions.assertThat(machine.getId()).isEqualTo(machineObj.getId());
	}
	
	@Test
	@DisplayName("This method is to add machine")
	void addMachineTest() {
		
		final MachineServiceImpl machineServiceImpl = new MachineServiceImpl(machineRepository);
		final Machine machine = new Machine(1, "testMachine", "testMachineType", "yes", "yes", "no", 1);
		Mockito.when(machineRepository.save(machine)).thenReturn(machine);
		
		final Machine machineObj = machineServiceImpl.save(machine);
		
		Assertions.assertThat(machineObj.getMachineName()).isEqualTo(machineObj.getMachineName());
		
	}

}
