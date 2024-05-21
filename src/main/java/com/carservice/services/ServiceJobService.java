package com.carservice.services;

import com.carservice.data.entities.ServiceJob;
import com.carservice.data.enums.JobState;
import com.carservice.data.enums.JobType;
import com.carservice.dto.ServiceJobDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.util.List;

public interface ServiceJobService {
	List<ServiceJobDTO> allServiceJobs();

	ServiceJobDTO findServiceJobById(@Min(1) int id);

	ServiceJob create(@Valid ServiceJobDTO serviceJobDTO);

//	ServiceJob update(@Min(1) int id, @Valid ServiceJobDTO serviceJobDTO);

	void delete(@Min(1) int id);

	//List<ServiceJobDTO> findServiceJobsByCarVin(String vin);

	List<ServiceJobDTO> findServiceJobsByEmployeeEmail(String email);

	List<ServiceJobDTO> findServiceJobsByState(JobState state);

	List<ServiceJobDTO> findServiceJobsByType(JobType type);

	List<ServiceJobDTO> findServiceJobByAppointmentId(@Min(1) int id);

	List<ServiceJobDTO> findServiceJobsByDateStarted(LocalDate date);

	List<ServiceJobDTO> findServiceJobsByDateFinished(LocalDate date);
}
