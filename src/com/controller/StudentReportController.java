package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ReportBean;
import com.bean.UserBean;
import com.dao.ReportDao;
import com.dao.UserDao;
@WebServlet("/ReportController")
public class StudentReportController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String UserId=request.getParameter("userId");
		int userId=Integer.parseInt(UserId);
		System.out.println(userId);
		String subject = request.getParameter("subject");
		String Attendance = request.getParameter("attendance");
		int attendance=Integer.parseInt(Attendance);
		String Logic=request.getParameter("logic");
		int logic=Integer.parseInt(Logic);
		String Comm=request.getParameter("comm");
		int comm=Integer.parseInt(Comm);
		String Grasping=request.getParameter("grasping");
		int grasping=Integer.parseInt(Grasping);
		String date=request.getParameter("date");
		String faculty=request.getParameter("faculty");
		ReportBean reportBean=new ReportBean();
		reportBean.setUserId(userId);
		reportBean.setSubject(subject);
		reportBean.setAttendance(attendance);
		reportBean.setLogic(logic);
		reportBean.setComm(comm);
		reportBean.setGrasping(grasping);
		reportBean.setDate(date);
		reportBean.setFaculty(faculty);
		ReportDao reportDao=new ReportDao();
		String msg=reportDao.insertReport(reportBean);
		request.setAttribute("userId", userId);
		request.setAttribute("msg", msg);
		if(msg.equals("done")) {
			request.getRequestDispatcher("StudentListController").forward(request, response);
			
		}
		else {
			request.getRequestDispatcher("GenReport.jsp").forward(request, response);
			
		}
	}
}
