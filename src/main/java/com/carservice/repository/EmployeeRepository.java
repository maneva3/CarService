package com.carservice.repository;

import com.carservice.data.entities.Employee;
import com.carservice.data.enums.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	Employee findByEmail(String email);

	Employee findByPhoneNumber(String phoneNumber);

	List<Employee> findByFirstName(String firstName);

	List<Employee> findByLastName(String lastName);

	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	@Query("SELECT e FROM Employee e JOIN e.qualifications qualification WHERE qualification = ?1")
	List<Employee> findAllByQualification(JobType qualification);

	@Query("SELECT e FROM Employee e JOIN e.workingAt carCenter WHERE carCenter.name = ?1")
	List<Employee> findAllByCarCenterName(String carCenterName);

}
