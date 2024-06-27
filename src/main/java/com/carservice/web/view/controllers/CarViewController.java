package com.carservice.web.view.controllers;


import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarDTO;
import com.carservice.exceptions.CarNotFoundException;
import com.carservice.exceptions.CustomerNotFoundException;
import com.carservice.services.CarService;
import com.carservice.web.view.models.CarViewModel;
import com.carservice.web.view.models.create.CreateCarViewModel;
import com.carservice.web.view.models.update.UpdateCarViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
		return "/cars";
	}

	@GetMapping("/create-car")
	public String showCreateCarForm(Model model) {
		model.addAttribute("brand", CarBrand.values());
		model.addAttribute("car", new CreateCarViewModel());
		return "cars/create-car";
	}

	@PostMapping("/create")
	public String createCar(@Valid @ModelAttribute("car") CreateCarViewModel car,
							BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("brand", CarBrand.values());
			return "/cars/create-car";
		}
		carService.create(modelMapper.map(car, CarDTO.class));
		return "redirect:/cars";
	}

	@PostMapping("/update/{licensePlate}")
	public String updateCar(@PathVariable("licensePlate") String licensePlate, @Valid UpdateCarViewModel updateCarViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "cars/edit-car";
		}
		carService.update(modelMapper.map(updateCarViewModel, CarDTO.class), licensePlate);
		return "redirect:/cars";
	}

	@ExceptionHandler({CarNotFoundException.class, CustomerNotFoundException.class})
	public String handleException(CarNotFoundException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "/error/car-errors";
	}

}
