package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bean.ReportBean;
import com.util.DbConnection;

public class ReportDao {

	public String insertReport(ReportBean reportBean) {
		
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into report(userId,subject,attendance,logic,comm,grasping,date,faculty) values (?,?,?,?,?,?,?,?)");
			pstmt.setLong(1, reportBean.getUserId());
			pstmt.setString(2, reportBean.getSubject());
			pstmt.setLong(3, reportBean.getAttendance());
			pstmt.setLong(4, reportBean.getLogic());
			pstmt.setLong(5, reportBean.getComm());
			pstmt.setLong(6, reportBean.getGrasping());
			pstmt.setString(7, reportBean.getDate());
			pstmt.setString(8, reportBean.getFaculty());
			int records=pstmt.executeUpdate();
			System.out.println(records+"Record inserted");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(e.getMessage().contains("truncation")) {
				return "please add value in limit";
			}
//			return e.getMessage();
		}
		return "done";
	}
	public ReportBean getUserById(int userId) {
		ReportBean reportBean = null;

		try {
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from report where userId = " + userId);

			if (rs.next()) {

				reportBean = new ReportBean();
				reportBean.setUserId(rs.getInt("userId"));
				reportBean.setSubject(rs.getString("subject"));
				reportBean.setAttendance(rs.getInt("attendance"));
				reportBean.setComm(rs.getInt("comm"));
				reportBean.setGrasping(rs.getInt("grasping"));
				reportBean.setLogic(rs.getInt("logic"));
				reportBean.setDate(rs.getString("date"));
				reportBean.setFaculty(rs.getString("faculty"));
	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reportBean;
	}

}
