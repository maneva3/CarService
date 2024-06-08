package com.carservice.web.api;

import com.carservice.data.entities.Customer;
import com.carservice.data.entities.Employee;
import com.carservice.services.CustomerService;
import com.carservice.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserApiController {
	private final CustomerService customerService;
	private final EmployeeService employeeService;

	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
}
