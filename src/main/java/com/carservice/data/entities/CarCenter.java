package com.carservice.data.entities;

import com.carservice.data.enums.CarBrand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "car_center")
public class CarCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	@NotBlank(message = "The name cannot be empty")
	@Size(max = 20, message = "The name cannot be longer than {max} characters")
	private String name;

	@Column(name = "work_with_brand")
	@Enumerated(EnumType.STRING)
	private CarBrand workWithBrand;

	@OneToMany(targetEntity = Appointment.class, mappedBy = "carCenter")
	private Set<Appointment> appointments;

	@OneToMany(targetEntity = Employee.class, mappedBy = "workingAt")
	private Set<Employee> employees;
}
