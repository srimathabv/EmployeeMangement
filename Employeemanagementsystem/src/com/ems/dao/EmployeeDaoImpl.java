package com.ems.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ems.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	Connection con;

	@Override
	public Connection getConnection() throws Exception  {
		// TODO Auto-generated method stub
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pallavi","root@new-ThinkPad","123");
       

		return con;
	}

	

	@Override
	public boolean save(Employee emp)  throws Exception
	{
		
		con = getConnection();
		PreparedStatement ps =con.prepareStatement("insert into Employee values (?,?,?,?)");
		ps.setString(1,emp.getEmpId());
		ps.setString(2,emp.getEmpName());
		LocalDate dobRaw= emp.getDob();
		ps.setDate(3,new java.sql.Date(dobRaw.getYear()-1900,dobRaw.getMonthValue()-1,dobRaw.getDayOfMonth()));
		ps.setFloat(4,emp.getBasicSalary());
		 int r=ps.executeUpdate();
		 
		 return r>0?true:false;
		
	}
	@Override
	public boolean delete(String empId) throws Exception {
		// TODO Auto-generated method stub
		con = getConnection();
		PreparedStatement ps = con.prepareStatement("delete from Employee where empId =?");
		ps.setString(1, empId);
		
		int rs = ps.executeUpdate();
		
		 return rs>0?true:false;
	}

	@Override
	public boolean update(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		con = getConnection();
		PreparedStatement ps = con.prepareStatement("update Employee set empName=?,dob=?,basicSalary=? where empId=?");
		ps.setString(1, emp.getEmpName());
		LocalDate dobRaw= emp.getDob();
		ps.setDate(2,new java.sql.Date(dobRaw.getYear(),dobRaw.getMonthValue(),dobRaw.getDayOfMonth()));
		ps.setFloat(3, emp.getBasicSalary());
		ps.setString(4, emp.getEmpId());
		
		int rs = ps.executeUpdate();
		 return rs >0?true:false;
	}
	

	@Override
	public Employee getEmployee(String empId) throws Exception {
		// TODO Auto-generated method stub
		con = getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Employee where empId =?");
		ps.setString(1, empId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			java.sql.Date rowDate= rs.getDate(3);
			Employee emp = new Employee(rs.getString(1),rs.getString(2),LocalDate.of(rowDate.getYear(),rowDate.getMonth(),
					rowDate.getDay()),rs.getFloat(4));
			return emp;
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		// TODO Auto-generated method stub
		con = getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Employee" );
		
		List<Employee> empList = new ArrayList<>();
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			java.sql.Date rowDate= rs.getDate(3);
			Employee emp = new Employee(rs.getString(1),rs.getString(2),LocalDate.of(rowDate.getYear()+1900,rowDate.getMonth()+1,
					rowDate.getDate()),rs.getFloat(4));
			
			empList.add(emp);
			
		}
		
		return empList;
	}

}
