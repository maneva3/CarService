package com.carservice.web.view.models.create;

import com.carservice.data.entities.Customer;
import com.carservice.data.enums.CarBrand;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
public class CreateCarViewModel {
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
}
