package com.carservice.services.impl;

import com.carservice.data.entities.Customer;
import com.carservice.dto.CustomerDTO;
import com.carservice.repository.CustomerRepository;
import com.carservice.services.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository repository;
	private final ModelMapper modelMapper;

	private CustomerDTO convertToCustomerDTO(Customer customer) {
		return modelMapper.map(customer, CustomerDTO.class);
	}

	@Override
	public List<CustomerDTO> allCustomers() {
		return repository.findAll().stream().map(this::convertToCustomerDTO).toList();
	}

	@Override
	public CustomerDTO findCustomerByEmail(@Valid String customerEmail) {
		return convertToCustomerDTO(repository.findByEmail(customerEmail));
	}

	@Override
	public CustomerDTO findCustomerByPhoneNumber(String phoneNumber) {
		return convertToCustomerDTO(repository.findByPhoneNumber(phoneNumber));
	}

	@Override
	public List<CustomerDTO> findCustomerByFirstName(String firstName) {
		return repository.findByFirstName(firstName).stream().map(this::convertToCustomerDTO).toList();
	}

	@Override
	public List<CustomerDTO> findCustomerByLastName(String lastName) {
		return repository.findByLastName(lastName).stream().map(this::convertToCustomerDTO).toList();
	}

	@Override
	public CustomerDTO findCustomerByLicensePlate(@Valid String licensePlate) {
		return convertToCustomerDTO(repository.findByCarLicensePlate(licensePlate));
	}

	@Override
	public CustomerDTO findCustomerByAppointmentId(Integer appointmentId) {
		return convertToCustomerDTO(repository.findByAppointmentId(appointmentId));
	}
}
