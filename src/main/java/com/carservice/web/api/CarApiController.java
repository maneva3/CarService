package com.carservice.web.api;

import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarDTO;
import com.carservice.services.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarApiController {
	private final CarService carService;
	private final ModelMapper modelMapper;

	@GetMapping("/")
	public List<CarDTO> allCars() {
		return carService.allCars();
	}

	@GetMapping("/{vin}")
	public CarDTO findCarByVin(@PathVariable("vin") String vin) {
		return carService.findCarByVin(vin);
	}

	@GetMapping("/{licensePlate}")
	public CarDTO findCarByLicensePlate(@PathVariable("licensePlate") String licensePlate) {
		return carService.findCarByLicensePlate(licensePlate);
	}

	/*@PutMapping("{licensePlate}")
	public Car updateLicensePlate(@PathVariable("licensePlate") String licensePlate, @RequestBody CarViewModel car) {
		return carService.updateLicensePlate(modelMapper.map(car, CarDTO.class), licensePlate);
	}*/

	@DeleteMapping("/{vin}")
	public void deleteCar(@PathVariable("vin") String vin) {
		carService.deleteCar(vin);
	}

	@GetMapping("/brand/{brand}")
	public List<CarDTO> findCarsByBrand(@PathVariable("brand") CarBrand brand) {
		return carService.findCarsByBrand(brand);
	}

	@GetMapping("/brand/{brand}/model/{model}")
	public List<CarDTO> findCarsByBrandAndModel(@PathVariable("brand") CarBrand brand, @PathVariable("model") String model) {
		return carService.findCarsByBrandAndModel(brand, model);
	}

	@GetMapping("/owner_email/{ownerEmail}")
	public List<CarDTO> findCarsByOwnerEmail(@PathVariable("ownerEmail") String ownerEmail) {
		return carService.findCarsByOwnerEmail(ownerEmail);
	}

	@GetMapping("/owner_phone/{ownerPhoneNumber}")
	public List<CarDTO> findCarsByOwnerPhoneNumber(@PathVariable("ownerPhoneNumber") String ownerPhoneNumber) {
		return carService.findCarsByOwnerPhoneNumber(ownerPhoneNumber);
	}

	@GetMapping("/model/{model}/year/{year}")
	public List<CarDTO> findCarsByModelAndYear(@PathVariable("model") String model, @PathVariable("year") LocalDate year) {
		return carService.findCarsByModelAndYear(model, year);
	}

	@GetMapping("/year/{year}")
	public List<CarDTO> findCarsByYear(@PathVariable("year") LocalDate year) {
		return carService.findCarsByYear(year);
	}
}
