package com.carservice.web.view.models.create;

import com.carservice.data.entities.Car;
import com.carservice.data.entities.CarCenter;
import com.carservice.data.entities.ServiceJob;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
public class CreateAppointmentViewModel {
	@NotEmpty(message = "The car center must be set!")
	private CarCenter carCenter;

	@NotEmpty(message = "The car must be set!")
	private Car car;

	@NotEmpty(message = "The date of appointment must be set!")
	@Future(message = "The date of appointment must be in the future!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfAppointment;

	@NotEmpty(message = "The service jobs must be set!")
	private Set<ServiceJob> serviceJobs;
}
