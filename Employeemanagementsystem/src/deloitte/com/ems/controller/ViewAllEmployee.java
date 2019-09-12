package deloitte.com.ems.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.model.Employee;
import com.ems.service.EmployeeServiceimpl;
import com.ems.service.Employeeservice;

/**
 * Servlet implementation class ViewAllEmployee
 */
@WebServlet("/ViewAllEmployee")
public class ViewAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   	 
	Employeeservice es;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  es=new EmployeeServiceimpl();
		
		List<Employee> list = new ArrayList<>();
	     
		try {
			 list = es.getAllEmployees();
			 HttpSession ssn = request.getSession();
			 ssn.setAttribute("elist", list);
			 response.sendRedirect("showall.jsp");
			 
		}
	        
		
	catch(Exception e) {
		e.printStackTrace();
	}
}
}	    
		
	