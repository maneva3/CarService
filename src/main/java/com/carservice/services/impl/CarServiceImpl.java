package com.carservice.services.impl;

import com.carservice.data.entities.Car;
import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarDTO;
import com.carservice.exceptions.CarNotFoundException;
import com.carservice.repository.CarRepository;
import com.carservice.services.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class CarServiceImpl implements CarService {
	private final CarRepository repository;
	private final ModelMapper modelMapper;

	private CarDTO convertToCarDTO(Car car) {
		return modelMapper.map(car, CarDTO.class);
	}

	@Override
	public List<CarDTO> allCars() {
		return repository.findAll().stream().map(this::convertToCarDTO).toList();
	}


	@Override
	public CarDTO findCarByLicensePlate(String licensePlate) {
		return modelMapper.map(repository.findById(licensePlate)
				.orElseThrow(() -> new CarNotFoundException("Car with license plate " + licensePlate + " not found")), CarDTO.class);
//		return convertToCarDTO(repository.findByLicensePlate(licensePlate));
	}

	@Override
	public Car create(CarDTO carDTO) {
		return repository.save(modelMapper.map(carDTO, Car.class));
	}

	@Override
	public Car update(CarDTO carDTO, String licensePlate) {
		Car car = modelMapper.map(carDTO, Car.class);
		car.changeLicensePlate(licensePlate);
		return repository.save(car);
	}

	@Override
	public void deleteCar(@Valid String vin) {
		repository.deleteById(vin);
	}

	@Override
	public List<CarDTO> findCarsByBrand(CarBrand brand) {
		return repository.findByBrand(brand).stream().map(this::convertToCarDTO).toList();
	}

	@Override
	public List<CarDTO> findCarsByBrandAndModel(CarBrand brand, String model) {
		return repository.findByBrandAndModel(brand, model).stream().map(this::convertToCarDTO).toList();
	}

	@Override
	public List<CarDTO> findCarsByOwnerEmail(String ownerEmail) {
		return repository.findByOwnerEmail(ownerEmail).stream().map(this::convertToCarDTO).toList();
	}

	@Override
	public List<CarDTO> findCarsByOwnerPhoneNumber(String ownerPhoneNumber) {
		return repository.findByOwnerPhoneNumber(ownerPhoneNumber).stream().map(this::convertToCarDTO).toList();
	}

	@Override
	public List<CarDTO> findCarsByModelAndYear(String model, LocalDate year) {
		return repository.findByModelAndYear(model, year).stream().map(this::convertToCarDTO).toList();
	}

	@Override
	public List<CarDTO> findCarsByYear(LocalDate year) {
		return repository.findByYear(year).stream().map(this::convertToCarDTO).toList();
	}
}
