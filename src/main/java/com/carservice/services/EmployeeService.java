package com.carservice.services;

import com.carservice.data.entities.Employee;
import com.carservice.dto.EmployeeDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
	List<EmployeeDTO> allEmployees();

	EmployeeDTO findEmployeeByEmail(String email);

	EmployeeDTO findEmployeeByPhoneNumber(String phoneNumber);

	Employee create(@Valid EmployeeDTO employeeDTO);

	Employee updateLastName(@Valid EmployeeDTO employeeDTO, String lastName);

	List<EmployeeDTO> findEmployeesByFirstName(String firstName);

	List<EmployeeDTO> findEmployeesByLastName(String lastName);

	List<EmployeeDTO> findEmployeesByQualification(String qualification);

	List<EmployeeDTO> findEmployeesByCarService(String carServiceName);
}
