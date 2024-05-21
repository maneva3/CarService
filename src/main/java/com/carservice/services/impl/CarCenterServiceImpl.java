package com.carservice.services.impl;

import com.carservice.data.entities.CarCenter;
import com.carservice.data.enums.CarBrand;
import com.carservice.dto.CarCenterDTO;
import com.carservice.repository.CarCenterRepository;
import com.carservice.services.CarCenterService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class CarCenterServiceImpl implements CarCenterService {
	private final CarCenterRepository repository;
	private final ModelMapper modelMapper;

	private CarCenterDTO convertToCarCenterDTO(CarCenter carCenter) {
		return modelMapper.map(carCenter, CarCenterDTO.class);
	}

	@Override
	public List<CarCenterDTO> allCarCenters() {
		return repository.findAll().stream().map(this::convertToCarCenterDTO).toList();
	}

	@Override
	public CarCenterDTO findCarCenterById(int id) {
		return modelMapper.map(repository.findById(id), CarCenterDTO.class);
	}

	@Override
	public CarCenter create(CarCenterDTO carCenterDTO) {
		return repository.save(modelMapper.map(carCenterDTO, CarCenter.class));
	}

//	@Override
//	public CarCenter update(int id, CarCenterDTO carCenterDTO) {
//		CarCenter carCenter = modelMapper.map(carCenterDTO, CarCenter.class);
//		carCenter.setId(id);
//		return repository.save(carCenter);
//	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<CarCenterDTO> findCarCenterByWorkingWithBrand(CarBrand brand) {

		return repository.findByWorkWithBrand(brand).stream().map(this::convertToCarCenterDTO).toList();
	}
}
