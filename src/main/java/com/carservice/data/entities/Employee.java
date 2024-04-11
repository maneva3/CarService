package com.carservice.data.entities;

import com.carservice.data.enums.JobType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "employee")
public class Employee extends User {
	@ElementCollection(targetClass = JobType.class, fetch = FetchType.EAGER)
	@Column(name = "qualifications")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "The qualifications must be set!")
	private Set<JobType> qualifications;

	@ManyToOne(targetEntity = CarCenter.class)
	@JoinColumn(name = "working_at")
	@NotNull(message = "The car center must be set!")
	private CarCenter workingAt;

	@OneToMany(targetEntity = ServiceJob.class, mappedBy = "employee")
	@Enumerated(EnumType.STRING)
	private Set<ServiceJob> workingOn;

	public void changeLastName(String lastName) {
		this.changeLastName(lastName);
	}
}
