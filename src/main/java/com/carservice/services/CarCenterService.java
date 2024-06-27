package com.carservice.services;

import com.carservice.data.entities.CarCenter;
import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarCenterDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface CarCenterService {
	List<CarCenterDTO> findAllCarCenters();

	CarCenterDTO findCarCenterById(@Min(1) int id);

	CarCenter create(@Valid CarCenterDTO carCenterDTO);

	CarCenter update(@Min(1) int id, @Valid CarCenterDTO carCenterDTO);

	void delete(@Min(1) int id);

	List<CarCenterDTO> findCarCenterByWorkingWithBrand(CarBrand brand);
}
