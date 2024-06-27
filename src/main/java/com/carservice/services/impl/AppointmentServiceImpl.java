package com.carservice.services.impl;

import com.carservice.data.entities.Appointment;
import com.carservice.dto.AppointmentDTO;
import com.carservice.exceptions.AppointmentNotFoundException;
import com.carservice.repository.AppointmentRepository;
import com.carservice.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class AppointmentServiceImpl implements AppointmentService {
	private final AppointmentRepository repository;
	private final ModelMapper modelMapper;

	private AppointmentDTO convertToAppointmentDTO(Appointment appointment) {
		return modelMapper.map(appointment, AppointmentDTO.class);
	}

	@Override
	public List<AppointmentDTO> allAppointments() {
		return repository.findAll().stream().map(this::convertToAppointmentDTO).toList();
	}

	@Override
	public AppointmentDTO findAppointmentById(int id) {
		return modelMapper.map(repository.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment with id " + id + " not found")), AppointmentDTO.class);
//		return convertToAppointmentDTO(repository.findById(id).orElse(null));
	}

	@Override
	public Appointment create(AppointmentDTO appointmentDTO) {
		return repository.save(modelMapper.map(appointmentDTO, Appointment.class));
	}

//	@Override
//	public Appointment updateAppointment(int id, AppointmentDTO appointmentDTO) {
//		Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
//		appointment.setId(id);
//		return repository.save(appointment);
//	}

	@Override
	public void deleteAppointment(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByCustomerEmail(String customerEmail) {
		return repository.findAllByCustomerEmail(customerEmail).stream().map(this::convertToAppointmentDTO).toList();
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByCustomerFirstName(String firstName) {
		return repository.findAllByCustomerFirstName(firstName).stream().map(this::convertToAppointmentDTO).toList();
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByCarLicensePlate(String licensePlate) {
		return repository.findAllByCarLicensePlate(licensePlate).stream().map(this::convertToAppointmentDTO).toList();
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByCarCenter(int carCenterId) {
		return repository.findAllByCarCenterId(carCenterId).stream().map(this::convertToAppointmentDTO).toList();
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByDateOfAppointment(LocalDate dateOfAppointment) {
		return repository.findAllByDateOfAppointment(dateOfAppointment).stream().map(this::convertToAppointmentDTO).toList();
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByDateCreated(LocalDate dateCreated) {
		return repository.findAllByDateCreated(dateCreated).stream().map(this::convertToAppointmentDTO).toList();
	}

	@Override
	public List<AppointmentDTO> findPassedAppointments() {
		return repository.findAllByHasPassedTrue().stream().map(this::convertToAppointmentDTO).toList();
	}

	@Override
	public List<AppointmentDTO> findOngoingAppointments() {
		return repository.findAllByHasPassedFalse().stream().map(this::convertToAppointmentDTO).toList();
	}
}
