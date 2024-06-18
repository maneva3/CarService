package com.carservice.web.view.controllers;

import com.carservice.dto.CustomerDTO;
import com.carservice.services.CustomerService;
import com.carservice.web.view.models.CustomerViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerViewController {
	private final CustomerService customerService;
	private final ModelMapper modelMapper;

	private CustomerViewModel convertToCustomerViewModel(CustomerDTO customerDTO) {
		return modelMapper.map(customerDTO, CustomerViewModel.class);
	}

	@GetMapping
	public String allCustomers(Model model) {
		final List<CustomerViewModel> customers = customerService.allCustomers()
				.stream()
				.map(this::convertToCustomerViewModel)
				.collect(Collectors.toList());
		model.addAttribute("customers", customers);
		return "/customers/customers";
	}
}