package com.carservice.data.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends User {
	@OneToMany(targetEntity = Car.class, mappedBy = "owner")
	private Set<Car> cars;

	@OneToMany(targetEntity = Appointment.class, mappedBy = "customer")
	private Set<Appointment> appointments;
}
