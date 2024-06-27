package com.carservice.web.view.controllers;

import com.carservice.dto.CarCenterDTO;
import com.carservice.exceptions.CarCenterNotFoundException;
import com.carservice.exceptions.CustomerNotFoundException;
import com.carservice.services.CarCenterService;
import com.carservice.web.view.models.CarCenterViewModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
		return "/car-centers/car-centers";
	}

	@GetMapping("/create")
	public String createCarCenter(@Valid @ModelAttribute("carCenter") CarCenterViewModel carCenter, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/car-centers/create-car-center";
		}
		carCenterService.create(modelMapper.map(carCenter, CarCenterDTO.class));
		return "redirect:/car-centers";
	}

	@GetMapping("/delete-car-center/{id}")
	public String deleteCarCenter(@PathVariable("id") int id) {
		carCenterService.delete(id);
		return "redirect:/car-centers";
	}

	@ExceptionHandler({CarCenterNotFoundException.class, CustomerNotFoundException.class})
	public String handleException(CarCenterNotFoundException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "/error/car-center-errors";
	}
}
