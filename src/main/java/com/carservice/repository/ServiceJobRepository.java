package com.carservice.repository;

import com.carservice.data.entities.ServiceJob;
import com.carservice.data.enums.JobState;
import com.carservice.data.enums.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceJobRepository extends JpaRepository<ServiceJob, Integer> {
	//List<ServiceJob> findAllByCarVin(String vin);

	List<ServiceJob> findAllByEmployeeEmail(String email);

	List<ServiceJob> findAllByState(JobState state);

	List<ServiceJob> findAllByType(JobType type);

	List<ServiceJob> findAllByAppointmentId(int id);

	List<ServiceJob> findAllByDateStarted(LocalDate date);

	List<ServiceJob> findAllByDateFinished(LocalDate date);
}
