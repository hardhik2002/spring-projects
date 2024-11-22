package com.employees.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.EmployeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
