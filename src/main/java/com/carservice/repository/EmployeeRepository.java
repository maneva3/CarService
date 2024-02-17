package com.carservice.repository;

import com.carservice.data.entities.Employee;
import com.carservice.data.enums.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByEmail(String email);
    Employee findByPhoneNumber(String phoneNumber);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    List<Employee> findByQualification(JobType qualification);
    List<Employee> findByCarCenter(String carCenter);

}
