package com.ems.service;

import java.time.LocalDate;


import java.util.List;
import java.util.Random;

import com.ems.dao.EmployeeDao;
import com.ems.dao.EmployeeDaoImpl;
import com.ems.model.Employee;

import com.ems.util.InvalidDobException;
import com.ems.util.InvalidNameException;
import com.ems.util.InvalidSalaryexception;

public class EmployeeServiceimpl implements Employeeservice {
	  EmployeeDao dao;
	  
	  public EmployeeServiceimpl() {
		  dao = new EmployeeDaoImpl();
	  }
	  
	  
	
	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		
		String empName = emp.getEmpName();
	
		LocalDate dob = emp.getDob();
		float salary = emp.getBasicSalary();
		 
		if(empName.length() <4 || empName.length() > 15)
		{
			throw new InvalidNameException("name must be on 4-15 characters");
			
		}
		
		if(dob.isAfter(LocalDate.of(1995,12,31)) || dob.isBefore(LocalDate.of(1900, 1, 1))){
			throw new InvalidDobException("please enter dob in range  01-01-1900 - 31-12-1995");
		}
		
		if(salary <=20000 || salary >=80000)
		{
			throw new InvalidSalaryexception("salary should be in the range of 20000-80000 ");
		
			
		}


		return true;
	}

	@Override
	public String generateId(String empName) {
		
		String nameChar=empName.substring(0,2).toUpperCase();
		Random rand = new Random();
		
		int dgt =(int) Math.round(rand.nextDouble() *10000);
		
		return nameChar + dgt ;
		
		
		
	}

	@Override
	public boolean save(Employee emp) throws Exception {
		// TODO Auto-generated method stub

		if(validateEmployee(emp))
		{
			emp.setEmpId(generateId(emp.getEmpName()));
			return dao.save(emp);
		}
		return false;
		
	}

	@Override
	public boolean delete(String empId) throws Exception {
	
	
		return dao.delete(empId);
	}

	@Override
	public boolean update(Employee emp) throws Exception {
		
		
		if(validateEmployee(emp))
		{
		return dao.update(emp);
		
		}
		return false;
	}

	@Override
	public Employee getEmployee(String empId) throws Exception {
		// TODO Auto-generated method stub
		Employee e= dao.getEmployee(empId);
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

}