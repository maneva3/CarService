package com.carservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarCenterDTO {
    private Long id;

    @NotBlank(message = "The name cannot be empty")
    @Size(max = 20, message = "The name cannot be longer than {max} characters")
    private String name;

    @Enumerated(EnumType.STRING)
    private String workWithBrand;

    private String appointments;

    private String employees;
}
