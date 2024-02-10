package com.carservice.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CreateCustomerDTO {
    @Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
    protected String email;

    @NotBlank(message = "The first name cannot be empty!")
    protected String firstName;

    @NotBlank(message = "The last name cannot be empty!")
    protected String lastName;

    @NotBlank(message = "The phone number cannot be empty!")
    @Pattern(regexp = "^\\+359\\d{9}$", message = "The phone number must be in the format +359xxxxxxxxx!")
    protected String phoneNumber;

    @NotBlank(message = "The password cannot be empty!")
    @Size(min = 8, max = 32, message = "The password must contain at least 8 characters!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 digit!")
    protected String password;
}
