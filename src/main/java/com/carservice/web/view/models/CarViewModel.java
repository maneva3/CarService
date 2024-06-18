package com.carservice.web.view.models;

import com.carservice.data.entities.Appointment;
import com.carservice.data.entities.Customer;
import com.carservice.data.enums.CarBrand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class CarViewModel {

	@NotBlank(message = "License plate cannot be blank!")
	@Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "License plate must be in format: XX0000XX")
	private String licensePlate;

	@NotBlank(message = "Brand must be set!")
	@Enumerated(EnumType.STRING)
	private CarBrand brand;

	@NotBlank(message = "Model cannot be blank!")
	@Size(max = 15, message = "Model can be up to {max} characters!")
	private String model;

	@Pattern(regexp = "(19\\d{2}|20\\d{2})", message = "Year must be between 1900 and 2099")
	@NotEmpty(message = "Year must be set!")
	private LocalDate year;

	@NotBlank(message = "Owner must be set!")
	private Customer owner;

	private Set<Appointment> appointments;
}
