package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/ReportGController")
public class ReportGController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int UserId = Integer.parseInt(userId);
		
		for (UserBean u:UserDao.listuser()) {
			if(u.getUserId()==UserId) {
				request.setAttribute("user", u);
				break;
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("GenReport.jsp");
	    rd.forward(request, response);
	}

}

