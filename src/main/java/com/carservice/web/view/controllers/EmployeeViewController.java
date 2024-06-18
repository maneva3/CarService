package com.carservice.web.view.controllers;

import com.carservice.dto.EmployeeDTO;
import com.carservice.services.EmployeeService;
import com.carservice.web.view.models.EmployeeViewModel;
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
@RequestMapping("/employees")
public class EmployeeViewController {
	private final EmployeeService employeeService;
	private final ModelMapper modelMapper;

	private EmployeeViewModel convertToEmployeeViewModel(EmployeeDTO employeeDTO) {
		return modelMapper.map(employeeDTO, EmployeeViewModel.class);
	}

	@GetMapping
	public String displayAllEmployees(Model model) {
		final List<EmployeeViewModel> employees = employeeService.findAll()
				.stream()
				.map(this::convertToEmployeeViewModel)
				.collect(Collectors.toList());
		System.out.println(employees);
		model.addAttribute("employees", employees);
		return "employees/employees";
	}
}
