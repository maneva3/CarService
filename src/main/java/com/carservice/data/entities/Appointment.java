package com.carservice.data.entities;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "customer_email")
	@NotEmpty(message = "The customer must be set!")
	private Customer customer;

	@ManyToOne(targetEntity = CarCenter.class)
	@JoinColumn(name = "car_center_id")
	@NotEmpty(message = "The car center must be set!")
	private CarCenter carCenter;

	@ManyToOne(targetEntity = Car.class)
	@JoinColumn(name = "car_license_plate")
	@NotEmpty(message = "The car must be set!")
	private Car car;

	@Column(name = "date_created")
	@NotEmpty(message = "The date created must be set!")
	@Convert(converter = LocalDateAttributeConverter.class)
	private final LocalDate dateCreated = LocalDate.now();

	@Column(name = "date_of_appointment")
	@NotEmpty(message = "The date of appointment must be set!")
	@Future(message = "The date of appointment must be in the future!")
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate dateOfAppointment;

	@OneToMany(targetEntity = ServiceJob.class, mappedBy = "appointment")
	@Column(name = "serviceJobs")
	@NotEmpty(message = "The service jobs must be set!")
	private Set<ServiceJob> serviceJobs;

	@Column(name = "has_passed")
	@BooleanFlag
	private Boolean hasPassed = false;

	@Override
	public String toString() {
		return "Appointment{" +
				", customer=" + customer +
				", carCenter=" + carCenter +
				", car=" + car +
				", dateCreated=" + dateCreated +
				", dateOfAppointment=" + dateOfAppointment +
				", serviceJobs=" + serviceJobs +
				", hasPassed=" + hasPassed +
				'}';
	}
}
