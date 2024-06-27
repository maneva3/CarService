package com.carservice.web.view.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserViewModel {
	@Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
	private String email;

	@NotBlank(message = "The first name cannot be empty!")
	private String firstName;

	@NotBlank(message = "The last name cannot be empty!")
	private String lastName;

	@NotBlank(message = "The phone number cannot be empty!")
	@Pattern(regexp = "^\\+359\\d{9}$", message = "The phone number must be in the format +359xxxxxxxxx!")
	private String phoneNumber;
}
