package com.employees.EmployeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.EmployeeManagement.entity.Employee;
import com.employees.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> employees() {
		return repository.findAll();
	}
	
	public List<Employee> saveEmployee(Employee employee) {
		repository.save(employee);
		return this.employees();
	}
	
	public List<Employee> deleteEmployee(Integer id) {
		Employee emp = repository.findById(id).orElse(null);
		if(emp != null) {
			repository.delete(emp);
		}
		return this.employees();
	}
	
	public Employee retireveEmployee(Integer id) {
		Employee emp = repository.findById(id).orElse(null);
		return emp;
	}
}
