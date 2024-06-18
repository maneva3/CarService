package com.carservice.web.api;

import com.carservice.data.enums.JobType;
import com.carservice.dto.EmployeeDTO;
import com.carservice.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
@Validated
public class EmployeeApiController {
	private final EmployeeService employeeService;
	private final ModelMapper modelMapper;

	@GetMapping("/")
	public List<EmployeeDTO> allEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/find-by-phone-number/{phoneNumber}")
	public EmployeeDTO findEmployeeByPhoneNumber(String phoneNumber) {
		return employeeService.findEmployeeByPhoneNumber(phoneNumber);
	}

	@GetMapping("/find-by-first-name/{firstName}")
	public List<EmployeeDTO> findEmployeesByFirstName(String firstName) {
		return employeeService.findEmployeesByFirstName(firstName);
	}

	@GetMapping("/find-by-last-name/{lastName}")
	public List<EmployeeDTO> findEmployeesByLastName(String lastName) {
		return employeeService.findEmployeesByLastName(lastName);
	}

	@GetMapping("/find-by-first-name-and-last-name/{firstName}/{lastName}")
	public EmployeeDTO findEmployeeByFirstNameAndLastName(String firstName, String lastName) {
		return employeeService.findEmployeeByFirstNameAndLastName(firstName, lastName);
	}

	@GetMapping("/find-by-qualification/{qualification}")
	public List<EmployeeDTO> findEmployeesByQualification(JobType qualification) {
		return employeeService.findEmployeesByQualification(qualification);
	}

	@GetMapping("/find-by-car-service/{carServiceName}")
	public List<EmployeeDTO> findEmployeesByCarService(String carServiceName) {
		return employeeService.findEmployeesByCarService(carServiceName);
	}
}
