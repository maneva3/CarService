package com.carservice.services.impl;

import com.carservice.data.entities.ServiceJob;
import com.carservice.data.enums.JobState;
import com.carservice.data.enums.JobType;
import com.carservice.dto.ServiceJobDTO;
import com.carservice.repository.ServiceJobRepository;
import com.carservice.services.ServiceJobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class ServiceJobServiceImpl implements ServiceJobService {
	private final ServiceJobRepository repository;
	private final ModelMapper modelMapper;

	private ServiceJobDTO convertToServiceJobDTO(ServiceJob serviceJob) {
		return modelMapper.map(serviceJob, ServiceJobDTO.class);
	}

	@Override
	public List<ServiceJobDTO> allServiceJobs() {
		return repository.findAll().stream().map(this::convertToServiceJobDTO).toList();
	}

	@Override
	public ServiceJobDTO findServiceJobById(int id) {
		return modelMapper.map(repository.findById(id), ServiceJobDTO.class);
	}

	@Override
	public ServiceJob create(ServiceJobDTO serviceJobDTO) {
		return repository.save(modelMapper.map(serviceJobDTO, ServiceJob.class));
	}

//	@Override
//	public ServiceJob update(int id, ServiceJobDTO serviceJobDTO) {
//		ServiceJob serviceJob = modelMapper.map(serviceJobDTO, ServiceJob.class);
//		serviceJob.setId(id);
//		return repository.save(serviceJob);
//	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<ServiceJobDTO> findServiceJobsByCarVin(String vin) {
		return repository.findAllByCarVin(vin).stream().map(this::convertToServiceJobDTO).toList();
	}

	@Override
	public List<ServiceJobDTO> findServiceJobsByEmployeeEmail(String email) {
		return repository.findAllByEmployeeEmail(email).stream().map(this::convertToServiceJobDTO).toList();
	}

	@Override
	public List<ServiceJobDTO> findServiceJobsByState(JobState state) {
		return repository.findAllByState(state).stream().map(this::convertToServiceJobDTO).toList();
	}

	@Override
	public List<ServiceJobDTO> findServiceJobsByType(JobType type) {
		return repository.findAllByType(type).stream().map(this::convertToServiceJobDTO).toList();
	}

	@Override
	public List<ServiceJobDTO> findServiceJobByAppointmentId(int id) {
		return repository.findAllByAppointmentId(id).stream().map(this::convertToServiceJobDTO).toList();
	}

	@Override
	public List<ServiceJobDTO> findServiceJobsByDateStarted(LocalDate date) {
		return repository.findAllByDateStarted(date).stream().map(this::convertToServiceJobDTO).toList();
	}

	@Override
	public List<ServiceJobDTO> findServiceJobsByDateFinished(LocalDate date) {
		return repository.findAllByDateFinished(date).stream().map(this::convertToServiceJobDTO).toList();
	}
}
