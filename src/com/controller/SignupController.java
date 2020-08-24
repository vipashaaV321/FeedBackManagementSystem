package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserBean userBean=new UserBean();
		userBean.setFirstName(firstName);
		userBean.setEmail(email);
		userBean.setPassword(password);
		UserDao userDao=new UserDao();
		String msg=userDao.insertUser(userBean);
		request.setAttribute("firstname", firstName);
		request.setAttribute("msg", msg);
		if(msg.equals("done")) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		}
		else {
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
			
		}
//		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}

