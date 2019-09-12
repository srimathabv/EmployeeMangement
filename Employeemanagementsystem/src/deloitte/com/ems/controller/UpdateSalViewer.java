package deloitte.com.ems.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.ems.model.Employee;


import com.ems.service.EmployeeServiceimpl;
import com.ems.service.Employeeservice;
@WebServlet("/updater")
public class UpdateSalViewer extends HttpServlet {
	
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
	Employeeservice es=null;
	Employee emp=null;
	es = new EmployeeServiceimpl();
	String empId=req.getParameter("empId");
	try {
		emp=es.getEmployee(empId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(es!=null) {
		HttpSession ssn=req.getSession();
		ssn.setAttribute("emp", emp);
		res.sendRedirect("Update.jsp");
	}
}
}