package com.carservice.data.entities;

import com.carservice.data.enums.CarBrand;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "car")
public class Car {
	@Id
	@Column(name = "license_plate")
	@NotBlank(message = "License plate cannot be blank!")
	@Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "License plate must be in format: XX0000XX")
	private String licensePlate;

	@Column(name = "brand")
	@NotBlank(message = "Brand must be set!")
	@Enumerated(EnumType.STRING)
	private CarBrand brand;

	@Column(name = "model")
	@NotBlank(message = "Model cannot be blank!")
	@Size(max = 15, message = "Model can be up to {max} characters!")
	private String model;

	@Column(name = "year")
	@Min(value = 1900, message = "Year must be between 1900 and 2099")
	@Max(value = 2099, message = "Year must be between 1900 and 2099")
	@NotEmpty(message = "Year must be set!")
	private Integer year;

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "owner_email")
	@NotBlank(message = "Owner must be set!")
	private Customer owner;

	@OneToMany(targetEntity = Appointment.class, mappedBy = "car")
	private Set<Appointment> appointments;

	public void changeLicensePlate(String newLicensePlate) {
		this.licensePlate = newLicensePlate;
	}
}
