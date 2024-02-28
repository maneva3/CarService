package com.carservice.repository;

import com.carservice.data.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	List<Appointment> findAllByCustomerEmail(String email);

	List<Appointment> findAllByCustomerFirstName(String firstName);

	List<Appointment> findAllByCarCenterId(int carCenterId);

	List<Appointment> findAllByCarLicensePlate(String licensePlate);

	List<Appointment> findAllByDateOfAppointment(LocalDate date);

	List<Appointment> findAllByDateCreated(LocalDate date);

	List<Appointment> findAllByHasPassedTrue();

	List<Appointment> findAllByHasPassedFalse();
}
