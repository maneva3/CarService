package com.carservice.web.api;

import com.carservice.dto.CustomerDTO;
import com.carservice.services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerApiController {
	private final CustomerService customerService;
	//	private final CarService carService;
//	private final AppointmentService appointmentService;
//	private final ServiceJobService serviceJobService;
//	private final EmployeeService employeeService;
	private final ModelMapper modelMapper;

	@GetMapping("/")
	public List<CustomerDTO> allCustomers() {
		return customerService.allCustomers();
	}

	@GetMapping("/{email}")
	public CustomerDTO findCustomerByEmail(@PathVariable String email) {
		return customerService.findCustomerByEmail(email);
	}

	@GetMapping("/{phoneNumber}")
	public CustomerDTO findCustomerByPhoneNumber(@PathVariable String phoneNumber) {
		return customerService.findCustomerByPhoneNumber(phoneNumber);
	}

	@GetMapping("/find-by-first-name/{firstName}")
	public List<CustomerDTO> findCustomerByFirstName(@PathVariable String firstName) {
		return customerService.findCustomerByFirstName(firstName);
	}

	@GetMapping("/find-by-last-name/{lastName}")
	public List<CustomerDTO> findCustomerByLastName(@PathVariable String lastName) {
		return customerService.findCustomerByLastName(lastName);
	}

	@GetMapping("/find-by-license-plate/{licensePlate}")
	public CustomerDTO findCustomerByLicensePlate(@PathVariable String licensePlate) {
		return customerService.findCustomerByLicensePlate(licensePlate);
	}

	@GetMapping("/find-by-appointment-id/{appointmentId}")
	public CustomerDTO findCustomerByAppointmentId(@PathVariable Integer appointmentId) {
		return customerService.findCustomerByAppointmentId(appointmentId);
	}
}

//	@PostMapping("/create")
//	public CustomerDTO createCustomer(@RequestBody CreateCustomerViewModel customer) {
//		return customerService.createCustomer(modelMapper.map(customer, CustomerDTO.class));
//	}
//
//	@PostMapping("/update")
//	public CustomerDTO updateCustomer(@RequestBody UpdateCustomerViewModel customer) {
//		return customerService.updateCustomer(modelMapper.map(customer, CustomerDTO.class));
//	}
//
//	@PostMapping("/delete")
//	public void deleteCustomer(@RequestBody DeleteCustomerViewModel customer) {
//		customerService.deleteCustomer(modelMapper.map(customer, CustomerDTO.class));
//	}
//
//	@PostMapping("/add-car")
//	public CarDTO addCar(@RequestBody AddCarViewModel car) {
//		return carService.addCar(modelMapper.map(car, CarDTO.class));
//	}
//
//	@PostMapping("/update-car")
//	public CarDTO updateCar(@RequestBody UpdateCarViewModel car) {
//		return carService.updateCar(modelMapper.map(car, CarDTO.class));
//	}
//
//	@PostMapping("/delete-car")
//	public void deleteCar(@RequestBody DeleteCarViewModel car) {
//		carService.deleteCar(modelMapper.map(car, CarDTO.class));
//}
