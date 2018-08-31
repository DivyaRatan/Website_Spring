package com.cg.example.demo.service;

import java.util.Collection;

import com.cg.example.demo.pojo.Employee;



public interface EmployeeServiceIntrfc {
	public void addEmployee(Employee employee);
	public Collection<Employee> viewAllEmployee();
	public void updateEmployee(Employee employee); 
	public void deleteEmployee(int employeeId); 
	public Employee getEmployeeById(int employeeId); 
}
