package com.carservice.services.impl;

import com.carservice.data.entities.Employee;
import com.carservice.data.enums.JobType;
import com.carservice.dto.EmployeeDTO;
import com.carservice.exceptions.EmployeeNotFoundException;
import com.carservice.repository.EmployeeRepository;
import com.carservice.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository repository;
	private final ModelMapper modelMapper;

	private EmployeeDTO convertToEmployeeDTO(Employee employee) {
		return modelMapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> findAll() {
		return repository.findAll().stream().map(this::convertToEmployeeDTO).toList();
	}

	@Override
	public EmployeeDTO findEmployeeByEmail(@Valid String email) {
		return modelMapper.map(repository.findById(email)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with email " + email + " not found")), EmployeeDTO.class);
//		return modelMapper.map(repository.findByEmail(email), EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO findEmployeeByPhoneNumber(String phoneNumber) {
		return modelMapper.map(repository.findByPhoneNumber(phoneNumber), EmployeeDTO.class);
	}

	@Override
	public Employee create(@Valid EmployeeDTO employeeDTO) {
		return repository.save(modelMapper.map(employeeDTO, Employee.class));
	}

	@Override
	public Employee save(@Valid Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee updateLastName(@Valid String email, String lastName) {
		Employee employee = repository.findByEmail(email);
		employee.changeLastName(lastName);
		return repository.save(employee);
	}

	@Override
	public List<EmployeeDTO> findEmployeesByFirstName(String firstName) {
		return repository.findByFirstName(firstName).stream().map(this::convertToEmployeeDTO).toList();
	}

	@Override
	public List<EmployeeDTO> findEmployeesByLastName(String lastName) {
		return repository.findByLastName(lastName).stream().map(this::convertToEmployeeDTO).toList();
	}

	@Override
	public EmployeeDTO findEmployeeByFirstNameAndLastName(String firstName, String lastName) {
		return modelMapper.map(repository.findByFirstNameAndLastName(firstName, lastName), EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> findEmployeesByQualification(JobType qualification) {
		return repository.findAllByQualification(qualification).stream().map(this::convertToEmployeeDTO).toList();
	}

	@Override
	public List<EmployeeDTO> findEmployeesByCarService(String carServiceName) {
		return repository.findAllByCarCenterName(carServiceName).stream().map(this::convertToEmployeeDTO).toList();
	}
}
