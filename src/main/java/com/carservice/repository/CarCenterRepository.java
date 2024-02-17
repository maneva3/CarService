package com.carservice.repository;

import com.carservice.data.entities.CarCenter;
import com.carservice.data.enums.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarCenterRepository extends JpaRepository<CarCenter, Integer> {
	List<CarCenter> findAllByName(String name);

	List<CarCenter> findByCarBrand(CarBrand carBrand);


}
