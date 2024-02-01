package com.carservice.data.entities;

import com.carservice.data.enums.JobState;
import com.carservice.data.enums.JobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "service_job")
public class ServiceJob {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee")
    private Employee employee;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "The type must be set!")
    private JobType type;

    @Column(name = "date_started")
    private LocalDate dateStarted;

    @Column(name = "date_finished")
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

}
