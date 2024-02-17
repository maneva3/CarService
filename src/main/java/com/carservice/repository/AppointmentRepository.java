package com.carservice.repository;

import com.carservice.data.entities.Appointment;
import com.carservice.data.entities.ServiceJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByCustomer_Email(String email);
    List<Appointment> findAllByCarCenterName(String name);
    List<Appointment> findAllByCar_LicensePlate(String licensePlate);
    List<Appointment> findAllByDateOfAppointment(String date);
    List<Appointment> findAllByServiceJobs(ServiceJob serviceJobs);
    List<Appointment> findAllByHasPassedTrue();
}
