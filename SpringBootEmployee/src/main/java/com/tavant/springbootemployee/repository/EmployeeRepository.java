package com.tavant.springbootemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tavant.springbootemployee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
