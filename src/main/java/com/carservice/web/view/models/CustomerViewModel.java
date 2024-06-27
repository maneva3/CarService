package com.carservice.web.view.models;

import com.carservice.data.entities.Appointment;
import com.carservice.data.entities.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class CustomerViewModel extends UserViewModel {
	private Set<Car> cars;

	private Set<Appointment> appointments;
}
