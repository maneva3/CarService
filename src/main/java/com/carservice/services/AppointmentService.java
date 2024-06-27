package com.carservice.services;

import com.carservice.data.entities.Appointment;
import com.carservice.dto.AppointmentDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
	List<AppointmentDTO> allAppointments();

	AppointmentDTO findAppointmentById(@Min(1) int id);

	Appointment create(@Valid AppointmentDTO appointmentDTO);

//	Appointment updateAppointment(@Min(1) int id, @Valid AppointmentDTO appointmentDTO);

	void deleteAppointment(@Min(1) int id);

	List<AppointmentDTO> findAppointmentsByCustomerEmail(String customerEmail);

	List<AppointmentDTO> findAppointmentsByCustomerFirstName(String firstName);

	List<AppointmentDTO> findAppointmentsByCarLicensePlate(String licensePlate);

	List<AppointmentDTO> findAppointmentsByCarCenter(int carCenterId);

	List<AppointmentDTO> findAppointmentsByDateOfAppointment(LocalDate dateOfAppointment);

	List<AppointmentDTO> findAppointmentsByDateCreated(LocalDate dateCreated);

	List<AppointmentDTO> findPassedAppointments();

	List<AppointmentDTO> findOngoingAppointments();
}
