package com.carservice.dto;

import com.carservice.data.entities.Appointment;
import com.carservice.data.entities.Employee;
import com.carservice.data.enums.JobState;
import com.carservice.data.enums.JobType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceJobDTO {
	private Integer id;

	@NotEmpty(message = "The customer must be set!")
	private Employee employee;

	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "The type must be set!")
	private JobType type;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateStarted;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFinished;

	@PositiveOrZero(message = "The price can't be negative")
	private BigDecimal price;

	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "The state must be set!")
	private JobState state = JobState.PENDING;

	private Appointment appointment;

}
