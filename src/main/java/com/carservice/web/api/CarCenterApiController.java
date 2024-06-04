package com.carservice.web.api;

import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarCenterDTO;
import com.carservice.services.CarCenterService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car-center")
@AllArgsConstructor
public class CarCenterApiController {
	private final CarCenterService carCenterService;
	private final ModelMapper modelMapper;

	@GetMapping("/")
	public List<CarCenterDTO> allCarCenters() {
		return carCenterService.allCarCenters();
	}

	@GetMapping("/{id}")
	public CarCenterDTO findCarCenterById(int id) {
		return carCenterService.findCarCenterById(id);
	}

	@PostMapping("/delete/{id}")
	public void deleteCarCenter(int id) {
		carCenterService.delete(id);
	}

	@GetMapping("/find-by-brand/{brand}")
	public List<CarCenterDTO> findCarCenterByWorkingWithBrand(CarBrand brand) {
		return carCenterService.findCarCenterByWorkingWithBrand(brand);
	}

}
