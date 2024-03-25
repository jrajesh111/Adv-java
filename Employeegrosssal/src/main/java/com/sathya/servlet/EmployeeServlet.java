package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		float empBSalary=Float.parseFloat(request.getParameter("empBSalary"));
		
	float da=0,hra=0,gross_sal=0,pf=0;
	if(empBSalary>=50000)
	{
		hra=(30*empBSalary)/100;
		da=(10*empBSalary)/100;
		pf=(6*empBSalary)/100;
//		gross_sal=empBSalary+hra+da-pf;
	}
	else if(empBSalary<50000 && empBSalary>25000) {
		hra=(20*empBSalary)/100;
		da=(5*empBSalary)/100;
		pf=(3*empBSalary)/100;
//		gross_sal=empBSalary+hra+da-pf;
	}
	else if(empBSalary<25000) {
		hra=(10*empBSalary)/100;
		da=(3*empBSalary)/100;
		pf=(2*empBSalary)/100;
//		gross_sal=empBSalary+hra+da-pf;
	}
	gross_sal=empBSalary+hra+da-pf;
	
	PrintWriter writer=response.getWriter();
	response.setContentType("text/html");
	writer.println("<html>");
	writer.println("<body bgcolor=\"pink\">");
//	writer.println("<h1>Employee Gross Salary</h1>");
	writer.println("<center><h1>Salary Calculation of Employee </h1>");
	writer.println("<center>Employee Id:"+empId);
	writer.print("<center>Employee Name:"+empName);
	writer.println("<center>Employee Basic Salary:"+empBSalary);
	writer.println("<center>HRA Amount:"+hra);
	writer.println("<center>DA Amount:"+da);
	writer.println("<center>PF Amount"+pf);
	writer.println("<center>Gross-Salary:"+gross_sal);
	writer.println("</html>");
	}
}
