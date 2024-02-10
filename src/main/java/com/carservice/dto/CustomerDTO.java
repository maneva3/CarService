package com.carservice.dto;

import com.carservice.data.entities.Appointment;
import com.carservice.data.entities.Car;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    @Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
    protected String email;

    @NotBlank(message = "The first name cannot be empty!")
    protected String firstName;

    @NotBlank(message = "The last name cannot be empty!")
    protected String lastName;

    @NotBlank(message = "The phone number cannot be empty!")
    @Pattern(regexp = "^\\+359\\d{9}$", message = "The phone number must be in the format +359xxxxxxxxx!")
    protected String phoneNumber;

    private Set<Car> cars;

    private Set<Appointment> appointments;
}
