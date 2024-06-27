package com.carservice.web.view.models;

import com.carservice.data.entities.CarCenter;
import com.carservice.data.entities.ServiceJob;
import com.carservice.data.enums.JobType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeViewModel extends UserViewModel {
	@Enumerated(EnumType.STRING)
	@NotNull(message = "The qualifications must be set!")
	private Set<JobType> qualifications;

	@NotNull(message = "The car center must be set!")
	private CarCenter workingAt;

	@Enumerated(EnumType.STRING)
	private Set<ServiceJob> workingOn;
}
