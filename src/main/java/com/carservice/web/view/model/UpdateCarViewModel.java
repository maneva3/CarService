package com.carservice.web.view.model;

import com.carservice.data.entities.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UpdateCarViewModel {
	String vin;

	@NotBlank(message = "License plate cannot be blank!")
	@Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "License plate must be in format: XX0000XX")
	private String licensePlate;

	@NotBlank(message = "Owner must be set!")
	private Customer owner;
}
