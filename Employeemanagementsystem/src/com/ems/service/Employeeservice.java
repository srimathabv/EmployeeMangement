package com.ems.service;

import java.util.List;

import com.ems.model.Employee;

public interface Employeeservice {
	
	public boolean validateEmployee(Employee emp) throws Exception;
	public String generateId(String empName);
;	public boolean save(Employee emp) throws Exception ;
	public boolean delete(String empId)throws Exception;
	public boolean update(Employee emp)throws Exception;
	public Employee getEmployee(String empId)throws Exception;
	public List<Employee> getAllEmployees()throws Exception;
}
