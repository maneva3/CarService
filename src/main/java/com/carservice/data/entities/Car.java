package com.carservice.data.entities;

import com.carservice.data.enums.CarBrand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "car")
public class Car {
	@Id
	@Column(name = "vin")
	@Pattern(regexp = "[A-HJ-NPR-Z0-9]{17}")
	private String vin;

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
	@Pattern(regexp = "(19\\d{2}|20\\d{2})", message = "Year must be between 1900 and 2099")
	@NotEmpty(message = "Year must be set!")
	private LocalDate year;

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "owner_email")
	@NotBlank(message = "Owner must be set!")
	private Customer owner;

	@OneToMany(targetEntity = Appointment.class, mappedBy = "car")
	private Set<Appointment> appointments;
}
