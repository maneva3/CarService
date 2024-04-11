package com.carservice.web.view.controllers;


import com.carservice.dto.CarDTO;
import com.carservice.services.CarService;
import com.carservice.web.view.models.CarViewModel;
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
@RequestMapping("/cars")
public class CarViewController {
	private final CarService carService;
	private final ModelMapper modelMapper;

	private CarViewModel convertToCarViewModel(CarDTO carDTO) {
		return modelMapper.map(carDTO, CarViewModel.class);
	}

	@GetMapping
	public String allCars(Model model) {
		final List<CarViewModel> cars = carService.allCars()
				.stream()
				.map(this::convertToCarViewModel)
				.collect(Collectors.toList());
		model.addAttribute("cars", cars);
		return "/cars/cars";
	}

//	@GetMapping("/create")
//	public String createCar(@Valid @ModelAttribute("car") CreateCarViewModel car, BindingResult bindingResult, Model model) {
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("brand")
//		}
//	}
}
