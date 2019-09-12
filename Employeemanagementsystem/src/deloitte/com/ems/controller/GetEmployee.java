package deloitte.com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.dao.EmployeeDaoImpl;
import com.ems.model.Employee;
import com.ems.service.EmployeeServiceimpl;

/**
 * Servlet implementation class GetEmployee
 */
@WebServlet("/get")
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		String empId = request.getParameter("id");
		EmployeeServiceimpl es = new EmployeeServiceimpl();
		Employee emp;
		
		try {
			
			emp = es.getEmployee(empId);
			//System.out.println(emp.getEmpId());
			HttpSession ssn = request.getSession();
			ssn.setAttribute("id", emp.getEmpId());
			ssn.setAttribute("name",emp.getEmpName());
			ssn.setAttribute("dob", emp.getDob());
			ssn.setAttribute("salary",emp.getBasicSalary());
			response.sendRedirect("show.jsp");
		}
		
		
	
		
		
		
	
		
	catch(Exception e) {
		e.printStackTrace();
	}
}
		    
		
}		
	

