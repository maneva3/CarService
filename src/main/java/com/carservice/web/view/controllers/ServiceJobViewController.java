package com.carservice.web.view.controllers;

import com.carservice.dto.ServiceJobDTO;
import com.carservice.services.ServiceJobService;
import com.carservice.web.view.models.ServiceJobViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@AllArgsConstructor
@RequestMapping("/service-jobs")
public class ServiceJobViewController {
	private final ServiceJobService serviceJobService;
	private final ModelMapper modelMapper;

	private ServiceJobViewModel convertToServiceJobViewModel(ServiceJobDTO serviceJobDTO) {
		return modelMapper.map(serviceJobDTO, ServiceJobViewModel.class);
	}

	@GetMapping
	public String allServiceJobs(Model model) {
		final List<ServiceJobViewModel> serviceJobs = serviceJobService.findAllServiceJobs().stream()
				.map(this::convertToServiceJobViewModel).collect(toList());
		model.addAttribute("serviceJobs", serviceJobs);
		return "/service-jobs/service-jobs";
	}
}
