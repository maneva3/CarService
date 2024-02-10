package com.carservice.dto;

import com.carservice.data.entities.Car;
import com.carservice.data.entities.CarCenter;
import com.carservice.data.entities.Customer;
import com.carservice.data.entities.ServiceJob;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppointmentDTO {
    private Long id;

    @NotEmpty(message = "The customer must be set!")
    private Customer customer;

    @NotEmpty(message = "The car center must be set!")
    private CarCenter carCenter;

    @NotEmpty(message = "The car must be set!")
    private Car car;

    @NotEmpty(message = "The date created must be set!")
    private final LocalDate dateCreated = LocalDate.now();

    @NotEmpty(message = "The date of appointment must be set!")
    @Future(message = "The date of appointment must be in the future!")
    private LocalDate dateOfAppointment;

    @NotEmpty(message = "The service jobs must be set!")
    private Set<ServiceJob> serviceJobs;

    @BooleanFlag
    private Boolean hasPassed = false;
}
