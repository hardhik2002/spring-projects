package com.employees.EmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employees.EmployeeManagement.entity.Employee;
import com.employees.EmployeeManagement.service.EmployeeService;
@CrossOrigin(origins="http://127.0.0.1:5500")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return empService.employees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		var result = empService.retireveEmployee(id);
		return result;
	}
	
	@PostMapping("/employees")
	public List<Employee> createEmployee(@RequestBody Employee employee) {
		return empService.saveEmployee(employee);
	}
	
	@PutMapping("/employees")
	public List<Employee> updateEmployee(@RequestBody Employee employee) {
		return empService.saveEmployee(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public List<Employee> deleteEmployee(@PathVariable Integer id) {
		return empService.deleteEmployee(id);
	}
}
