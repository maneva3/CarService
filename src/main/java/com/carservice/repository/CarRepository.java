package com.carservice.repository;

import com.carservice.data.entities.Car;
import com.carservice.data.enums.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

	Car findByLicensePlate(String licensePlate);

	List<Car> findByBrand(CarBrand brand);

	List<Car> findByBrandAndModel(CarBrand brand, String model);

	List<Car> findByYear(LocalDate year);

	List<Car> findByOwnerEmail(String email);

	List<Car> findByOwnerPhoneNumber(String phoneNumber);

	List<Car> findByModelAndYear(String model, LocalDate year);
}
