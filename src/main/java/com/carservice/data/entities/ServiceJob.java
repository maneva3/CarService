package com.carservice.data.entities;

import com.carservice.data.enums.JobState;
import com.carservice.data.enums.JobType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "service_job")
public class ServiceJob {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "employee_email")
	private Employee employee;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "The type must be set!")
	private JobType type;

	@Column(name = "date_started")
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate dateStarted;

	@Column(name = "date_finished")
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate dateFinished;

	@Column(name = "price")
	@PositiveOrZero(message = "The price can't be negative")
	private BigDecimal price;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "The state must be set!")
	private JobState state = JobState.PENDING;

	@ManyToOne(targetEntity = Appointment.class)
	@JoinColumn(name = "appointment_id")
	private Appointment appointment;

	@Override
	public String toString() {
		return "ServiceJob{" +
				", type=" + type +
				", dateStarted=" + dateStarted +
				", dateFinished=" + dateFinished +
				", price=" + price +
				", state=" + state +
				'}';
	}
}
