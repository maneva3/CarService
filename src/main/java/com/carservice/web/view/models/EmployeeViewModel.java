package com.carservice.web.view.models;

import com.carservice.data.entities.CarCenter;
import com.carservice.data.entities.ServiceJob;
import com.carservice.data.enums.JobType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@NoArgsConstructor
public class EmployeeViewModel {
	@Email(regexp = ".+[@].+[\\.].+", message = "Invalid email format!")
	protected String email;

	@NotBlank(message = "The first name cannot be empty!")
	protected String firstName;

	@NotBlank(message = "The last name cannot be empty!")
	protected String lastName;

	@NotBlank(message = "The phone number cannot be empty!")
	@Pattern(regexp = "^\\+359\\d{9}$", message = "The phone number must be in the format +359xxxxxxxxx!")
	protected String phoneNumber;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "The qualifications must be set!")
	private Set<JobType> qualifications;

	@NotNull(message = "The car center must be set!")
	private CarCenter workingAt;

	@Enumerated(EnumType.STRING)
	private Set<ServiceJob> workingOn;
}
