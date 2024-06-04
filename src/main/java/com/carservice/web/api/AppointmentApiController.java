package com.carservice.web.api;

import com.carservice.dto.AppointmentDTO;
import com.carservice.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@AllArgsConstructor
public class AppointmentApiController {
	private final AppointmentService appointmentService;
	private final ModelMapper modelMapper;

	@GetMapping("/")
	public List<AppointmentDTO> allAppointments() {
		return appointmentService.allAppointments();
	}

	@GetMapping("/find-by-id/{id}")
	public AppointmentDTO findAppointmentById(int id) {
		return appointmentService.findAppointmentById(id);
	}

	@GetMapping("/find-by-customer-email/{customerEmail}")
	public List<AppointmentDTO> findAppointmentsByCustomerEmail(String customerEmail) {
		return appointmentService.findAppointmentsByCustomerEmail(customerEmail);
	}

	@GetMapping("/find-by-customer-first-name/{firstName}")
	public List<AppointmentDTO> findAppointmentsByCustomerFirstName(String firstName) {
		return appointmentService.findAppointmentsByCustomerFirstName(firstName);
	}

	@GetMapping("/find-by-car-license-plate/{licensePlate}")
	public List<AppointmentDTO> findAppointmentsByCarLicensePlate(String licensePlate) {
		return appointmentService.findAppointmentsByCarLicensePlate(licensePlate);
	}

	@GetMapping("/find-by-car-center/{carCenterId}")
	public List<AppointmentDTO> findAppointmentsByCarCenter(int carCenterId) {
		return appointmentService.findAppointmentsByCarCenter(carCenterId);
	}

	@GetMapping("/find-by-date-of-appointment/{dateOfAppointment}")
	public List<AppointmentDTO> findAppointmentsByDateOfAppointment(LocalDate dateOfAppointment) {
		return appointmentService.findAppointmentsByDateOfAppointment(dateOfAppointment);
	}

	@GetMapping("/find-by-date-created/{dateCreated}")
	public List<AppointmentDTO> findAppointmentsByDateCreated(LocalDate dateCreated) {
		return appointmentService.findAppointmentsByDateCreated(dateCreated);
	}

	@GetMapping("/find-passed-appointments")
	public List<AppointmentDTO> findPassedAppointments() {
		return appointmentService.findPassedAppointments();
	}

	@GetMapping("/find-ongoing-appointments")
	public List<AppointmentDTO> findOngoingAppointments() {
		return appointmentService.findOngoingAppointments();
	}
}
