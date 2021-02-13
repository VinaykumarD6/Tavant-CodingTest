package com.tavant.springbootemployee.controller;

import java.util.*;
import java.lang.*;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.springbootemployee.repository.EmployeeRepository;
import com.tavant.springbootemployee.model.Employee;

@RestController

public class EmployeeController {
	EmployeeRepository employeeRepository;
	
	//to get Hello message using get method
	@GetMapping
	public String getEmployee() {
		return "Hello from me!!!!!!!";
	}
	
	//To get all employees
	@GetMapping("/all")
	public  List<Employee> getAllEmployees() throws Exception
	{
		List list  = this.employeeRepository.findAll();
		return Optional.ofNullable(list.isEmpty()?null:list).orElseThrow(null);
	}
	
	
	
	//To get employee based to given id
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeeById(@PathVariable("id") Integer id) throws Exception{
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return null;
	}
	
	//To insert new employee
	@PostMapping
	public Employee addEmployee(@RequestBody @Valid Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//To delete employee based on id	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeRepository.deleteById(id);
	}
	
	
	//To update employees based on given id
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody @Valid Employee newEmployee, @PathVariable Integer id) {
		return employeeRepository.findById(id).map(employee ->{
			employee.setFirstName(newEmployee.getFirstName());
			employee.setLastName(newEmployee.getLastName());
			employeeRepository.save(employee);
		}).orElseGet(()->{
			newEmployee.setId(id);
			employeeRepository.save(newEmployee);
		});
	}
	
}
