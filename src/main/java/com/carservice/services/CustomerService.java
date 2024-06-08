package com.carservice.services;

import com.carservice.data.entities.Customer;
import com.carservice.dto.CustomerDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {
	List<CustomerDTO> allCustomers();

	Customer save(@Valid Customer customer);

	CustomerDTO findCustomerByEmail(String email);

	CustomerDTO findCustomerByPhoneNumber(String phoneNumber);

	List<CustomerDTO> findCustomerByFirstName(String firstName);

	List<CustomerDTO> findCustomerByLastName(String lastName);

	CustomerDTO findCustomerByLicensePlate(String licensePlate);

	CustomerDTO findCustomerByAppointmentId(Integer appointmentId);
}
