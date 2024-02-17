package com.carservice.services;

import com.carservice.data.entities.Car;
import com.carservice.dto.CarDTO;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

public interface CarService {
	List<CarDTO> allCars();

	CarDTO findCarByVin(String vin);

	CarDTO findCarByLicensePlate(String licensePlate);

	Car create(@Valid CarDTO carDTO);

	Car updateLicensePlate(@Valid CarDTO carDTO, String licensePlate);

	void deleteCar(String vin);

	List<CarDTO> findCarsByModel(String model);

	List<CarDTO> findCarsByOwner(String ownerEmail);

	List<CarDTO> findCarsByModelAndYear(String model, LocalDate year);

	List<CarDTO> findCarsByBrand(String brand);

	List<CarDTO> findCarsByYear(LocalDate year);
}
