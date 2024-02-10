package com.carservice.dto;

import com.carservice.data.entities.Appointment;
import com.carservice.data.entities.Employee;
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
public class ServiceJobDTO {
    private Long id;

    private Employee employee;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "The type must be set!")
    private JobType type;

    private LocalDate dateStarted;

    @Column(name = "date_finished")
    private LocalDate dateFinished;

    @PositiveOrZero(message = "The price can't be negative")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "The state must be set!")
    private JobState state = JobState.PENDING;

    private Appointment appointment;

}
