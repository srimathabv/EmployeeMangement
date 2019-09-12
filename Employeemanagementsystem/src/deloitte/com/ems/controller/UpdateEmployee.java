package deloitte.com.ems.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.model.Employee;
import com.ems.service.EmployeeServiceimpl;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/update")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// String id = request.getParameter("id");
		 String username = request.getParameter("username");
		 String date = request.getParameter("dob");
		 long salary = Long.parseLong(request.getParameter("salary"));
		 

			
			LocalDate dob;
			
			StringTokenizer stk = new StringTokenizer(date, "-");
			int strdate = Integer.parseInt(stk.nextToken());
			int month = Integer.parseInt(stk.nextToken());
			int year = Integer.parseInt(stk.nextToken());
			dob = LocalDate.of(year,month,strdate);
			
	             Employee emp = new Employee() ;           
		 emp.setEmpName(username);
			emp.setBasicSalary(salary);
			emp.setDob(dob);
		//	emp.setEmpId(id);

		
		EmployeeServiceimpl es = new EmployeeServiceimpl();
	     
		
		try {
			
	          es.update(emp);
	          response.sendRedirect("success.jsp");
		}
	
	catch(Exception e) {
		e.printStackTrace();
		response.sendRedirect("fail.jsp");
	}
}
}	    
		


