package com.carservice.web.view.controllers;

import com.carservice.dto.CarCenterDTO;
import com.carservice.services.CarCenterService;
import com.carservice.web.view.models.CarCenterViewModel;
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
@RequestMapping("/car-service")
public class CarCenterViewController {
	private final CarCenterService carCenterService;
	private final ModelMapper modelMapper;

	private CarCenterViewModel convertToCarCenterViewModel(CarCenterDTO carCenterDTO) {
		return modelMapper.map(carCenterDTO, CarCenterViewModel.class);
	}

	@GetMapping
	public String showCarService(Model model) {
		final List<CarCenterViewModel> carCenters = carCenterService.findAllCarCenters().stream()
				.map(this::convertToCarCenterViewModel).collect(toList());
		model.addAttribute("carCenters", carCenters);
		return "/car-centers";
	}
}
