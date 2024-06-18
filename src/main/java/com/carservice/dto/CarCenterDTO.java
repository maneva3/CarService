package com.carservice.dto;

import com.carservice.data.enums.CarBrand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarCenterDTO {
	private Integer id;

	@NotBlank(message = "The name cannot be empty")
	@Size(max = 20, message = "The name cannot be longer than {max} characters")
	private String name;

	@Enumerated(EnumType.STRING)
	private CarBrand workWithBrand;

	private List<String> appointments;

	private List<String> employees;
}
