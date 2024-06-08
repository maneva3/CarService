package com.carservice.web.api;

import com.carservice.data.enums.JobState;
import com.carservice.data.enums.JobType;
import com.carservice.dto.ServiceJobDTO;
import com.carservice.services.ServiceJobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/service-job")
@AllArgsConstructor
public class ServiceJobApiController {
	private final ServiceJobService serviceJobService;
	private final ModelMapper modelMapper;

	@GetMapping("/")
	public List<ServiceJobDTO> allServiceJobs() {
		return serviceJobService.findAllServiceJobs();
	}

	@GetMapping("/{id}")
	public ServiceJobDTO findServiceJobById(int id) {
		return serviceJobService.findServiceJobById(id);
	}

//	@GetMapping("/find-by-car-vin/{vin}")
//	public List<ServiceJobDTO> findServiceJobsByCarVin(String vin) {
//		return serviceJobService.findServiceJobsByCarVin(vin);
//	}

	@GetMapping("/find-by-employee-email/{email}")
	public List<ServiceJobDTO> findServiceJobsByEmployeeEmail(String email) {
		return serviceJobService.findServiceJobsByEmployeeEmail(email);
	}

	@GetMapping("/find-by-state/{state}")
	public List<ServiceJobDTO> findServiceJobsByState(JobState state) {
		return serviceJobService.findServiceJobsByState(state);
	}

	@GetMapping("/find-by-type/{type}")
	public List<ServiceJobDTO> findServiceJobsByType(JobType type) {
		return serviceJobService.findServiceJobsByType(type);
	}

	@GetMapping("/find-by-appointment-id/{id}")
	public List<ServiceJobDTO> findServiceJobByAppointmentId(int id) {
		return serviceJobService.findServiceJobByAppointmentId(id);
	}

	@GetMapping("/find-by-date-started/{date}")
	public List<ServiceJobDTO> findServiceJobsByDateStarted(LocalDate date) {
		return serviceJobService.findServiceJobsByDateStarted(date);
	}

	@GetMapping("/find-by-date-finished/{date}")
	public List<ServiceJobDTO> findServiceJobsByDateFinished(LocalDate date) {
		return serviceJobService.findServiceJobsByDateFinished(date);
	}
}
