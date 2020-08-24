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
import com.dao.ReportDao;
@WebServlet("/DisplayReportController")
public class DisplayReportController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
int userId = Integer.parseInt(request.getParameter("userId"));
	ReportBean reportBean = new ReportDao().getUserById(userId);
	request.setAttribute("report",reportBean);
//	ReportDao userDao=new ReportDao();
//	ArrayList<ReportBean> users=userDao.getUserById(userId);		
	request.getRequestDispatcher("DisplayReport.jsp").forward(request, response);	
	}
}
