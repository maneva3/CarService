package com.carservice.web.view.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
public class CarCenterViewModel {
	@NotBlank(message = "The name cannot be empty")
	@Size(max = 20, message = "The name cannot be longer than {max} characters")
	private String name;

	@Enumerated(EnumType.STRING)
	private String workWithBrand;

	private String appointments;

	private String employees;
}
