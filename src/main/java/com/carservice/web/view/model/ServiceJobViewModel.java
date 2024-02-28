package com.carservice.web.view.model;

import com.carservice.data.entities.Appointment;
import com.carservice.data.entities.Employee;
import com.carservice.data.enums.JobState;
import com.carservice.data.enums.JobType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
public class ServiceJobViewModel {
	@NotEmpty(message = "The customer must be set!")
	private Employee employee;

	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "The type must be set!")
	private JobType type;

	private LocalDate dateStarted;
	
	private LocalDate dateFinished;

	@PositiveOrZero(message = "The price can't be negative")
	private BigDecimal price;

	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "The state must be set!")
	private JobState state = JobState.PENDING;

	private Appointment appointment;
}
