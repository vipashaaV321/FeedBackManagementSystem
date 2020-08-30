package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
@WebServlet(value="/LoginController")
public class LoginController extends HttpServlet{
	String adminEmail ;
	String adminPassword ;
	String adminName;
	String wish;
	String globalEmail,globalPassword;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		adminName="Admin";
		adminEmail  = "admin@gmail.com";
		adminPassword = "admin";
		 Calendar cal = Calendar.getInstance();
	      // current date and time
	      System.out.println(cal.getTime().toString());
	      // time information
	      System.out.println("Hour (24 hour format) : " + cal.get(Calendar.HOUR_OF_DAY));
	      PrintWriter out = response.getWriter();  
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		String UserId=request.getParameter("userId");
		RequestDispatcher rd  = null;
		if(adminEmail.equals(email) && adminPassword.equals(password)) {
				rd = request.getRequestDispatcher("AdminHome.jsp");
				request.setAttribute("msg","you have Logged in succesfully");
				HttpSession session = request.getSession(); //login -> session server if not found new session will create and return 
				session.setAttribute("email", email);
				session.setAttribute("name", password);
				 if(cal.get(Calendar.HOUR_OF_DAY)>0 && cal.get(Calendar.HOUR_OF_DAY)<12) {
			    	  request.setAttribute("wish", "Good Morning");
			    	  System.out.println("gm");
			      }
			      else {
			    	  request.setAttribute("wish", "Good Night");
			    	  System.out.println("gn");
			      }
		}
		else if (UserDao.getLogin(email,password)) {
			rd = request.getRequestDispatcher("UserHome.jsp");
			request.setAttribute("msg","you have Logged in succesfully");
			HttpSession session = request.getSession(); //login -> session server if not found new session will create and return 
			session.setAttribute("email", email);
			
		}
		else {
			rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("msg", "Invalid Credentials!!!");
		}
	
		rd.forward(request, response);
	}	
}
