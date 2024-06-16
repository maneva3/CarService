package com.carservice.dto;

import com.carservice.data.entities.Appointment;
import com.carservice.data.entities.Customer;
import com.carservice.data.enums.CarBrand;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDTO {
	@NotBlank(message = "License plate cannot be blank!")
	@Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "License plate must be in format: XX0000XX")
	private String licensePlate;

	@NotBlank(message = "Brand must be set!")
	@Enumerated(EnumType.STRING)
	private CarBrand brand;

	@NotBlank(message = "Model cannot be blank!")
	@Size(max = 15, message = "Model can be up to {max} characters!")
	private String model;

	@Min(value = 1900, message = "Year must be between 1900 and 2099")
	@Max(value = 2099, message = "Year must be between 1900 and 2099")
	@NotEmpty(message = "Year must be set!")
	private Integer year;

	@NotBlank(message = "Owner must be set!")
	private Customer owner;

	private Set<Appointment> appointments;
}