package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet{

protected void service(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

HttpSession session = request.getSession();
session.invalidate();
//
//RD-> carry forward // request -> data set -> existing request carry forward

response.sendRedirect("Login.jsp");//new request

}
}