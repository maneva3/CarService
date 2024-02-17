package com.carservice.services;

import com.carservice.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
	List<CustomerDTO> allCustomers();

	CustomerDTO findCustomer(String email);

	CustomerDTO findCustomerByPhoneNumber(String phoneNumber);

	List<CustomerDTO> findCustomerByFirstName(String firstName);

	List<CustomerDTO> findCustomerByLastName(String lastName);

	CustomerDTO findCustomerByLicensePlate(String licensePlate);

	CustomerDTO findCustomerByAppointmentId(Integer appointmentId);
}
