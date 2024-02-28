package com.carservice.repository;

import com.carservice.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	Customer findByEmail(String email);

	Customer findByPhoneNumber(String phoneNumber);

	List<Customer> findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);
    
	@Query("SELECT customer FROM Customer customer JOIN customer.cars car WHERE car.licensePlate = ?2")
	Customer findByCarLicensePlate(String carLicensePlate);

	@Query("SELECT customer FROM Customer customer JOIN customer.appointments appointment WHERE appointment.id = ?1")
	Customer findByAppointmentId(Integer appointmentId);

}
