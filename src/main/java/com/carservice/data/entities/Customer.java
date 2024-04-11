package com.carservice.data.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
