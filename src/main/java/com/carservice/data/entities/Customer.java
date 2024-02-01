package com.carservice.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "customer")
public class Customer extends User {
    @OneToMany(targetEntity = Car.class, mappedBy = "owner")
    private Set<Car> cars;

    @OneToMany(targetEntity = Appointment.class, mappedBy = "customer")
    private Set<Appointment> appointments;
}
