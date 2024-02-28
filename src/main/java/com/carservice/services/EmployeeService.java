package com.carservice.services;

import com.carservice.data.entities.Employee;
import com.carservice.data.enums.JobType;
import com.carservice.dto.EmployeeDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
	List<EmployeeDTO> allEmployees();

	EmployeeDTO findEmployeeByEmail(String email);

	EmployeeDTO findEmployeeByPhoneNumber(String phoneNumber);

	Employee create(@Valid EmployeeDTO employeeDTO);

	Employee updateLastName(@Valid String email, String lastName);

	List<EmployeeDTO> findEmployeesByFirstName(String firstName);

	List<EmployeeDTO> findEmployeesByLastName(String lastName);

	EmployeeDTO findEmployeeByFirstNameAndLastName(String firstName, String lastName);

	List<EmployeeDTO> findEmployeesByQualification(JobType qualification);

	List<EmployeeDTO> findEmployeesByCarService(String carServiceName);
}
