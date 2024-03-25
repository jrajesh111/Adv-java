package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateNumberServlet")
public class GenerateNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("operation");
		ArrayList<Integer> l=new ArrayList<Integer>();
		switch(operation) 
		{
		case "Even":for(int i=num1;i<=num2;i++)
						if(i%2==0)
							l.add(i);
						
						break;
		case "Odd":for(int i=num1;i<=num2;i++)
						if(i%2==1)
							l.add(i);
						break;				
		case "Prime":int f=0;
		for(int i=num1;i<=num2;i++)
		{
			 f=0;
			for(int j=2;j<=i/2;j++)
			{
				if(i%j==0)
				{
					f=1;
					break;
				}
			}
			if(f==0 && i!=1)
				l.add(i);
		}
				break;
				
		case "Perfect":int sum=0;
			for(int i=num1;i<=num2;i++)
			{
					sum=0;
					for(int j=1;j<i;j++)
					{
						if(i%j==0)
							sum+=j;
					}
					if(sum==i)
						l.add(i);
			}
			break;
		case "Strong":for(int i=num1;i<=num2;i++)
			{
			int temp=i,rem=0,fact=1,sum1=0;
			while(temp>0)
			{
				rem=temp%10;
				if(rem==0)
				fact=1;
				else
				{
				fact=1;
				for(int j=1;j<=rem;j++)
					fact=fact*j;
				}
				sum1=sum1+fact;
				temp=temp/10;
			}
			if(i==sum1)
				l.add(i);
			}
			break;
		case "Armstrong":for(int i=num1;i<=num2;i++)
		{
			int temp=i,count=0,rem=0;
			double sum1=0;
			while(temp>0)
			{
				count++;
				temp=temp/10;
			}
			int temp1=i;
			while(temp1>0)
			{
				rem=temp1%10;
				sum1=sum1+Math.pow(rem, count);
				temp1=temp1/10;
			}
			if(sum1==i)
				l.add(i);
			}
		break;
		}
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor="+"pink"+">"+"<br>");
		writer.print("<h1> Generate Numbers Operation</h1>");
		writer.println("Enter the FirstNumber :"+num1+"<br>");
		writer.println("Enter the SecondNumber:   "+num2+"<br>");
		writer.println("Enter the operation:  "+operation+"<br>");
		writer.println("Result: "+l);
		writer.println("</body>");
		writer.println("</html>");	
	}		
}


