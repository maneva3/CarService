package com.carservice.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends User {
	@OneToMany(targetEntity = Car.class, mappedBy = "owner")
	private Set<Car> cars;

	@OneToMany(targetEntity = Appointment.class, mappedBy = "customer")
	private Set<Appointment> appointments;

	@Override
	public String toString() {
		return "Customer{" +
				"email=" + email +
				", first name='" + firstName +
				", last name='" + lastName +
				", phone number='" + phoneNumber +
				", cars=" + cars +
				'}';
	}
}
