package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;
import com.bean.ReportBean;
import com.bean.UserBean;
import com.dao.ReportDao;
import com.dao.UserDao;

@WebServlet("/UserHomeController")
public class UserHomeController  extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email= request.getParameter("email");
		UserBean userBean = new UserDao().getUserByEmail(email);
		request.setAttribute("user",userBean);
		request.getRequestDispatcher("UserReport.jsp").forward(request, response);	
	}
}

