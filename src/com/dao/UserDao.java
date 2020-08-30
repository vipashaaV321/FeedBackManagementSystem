package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.ReportBean;
import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {
	public String insertUser(UserBean userBean){
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into user(firstName,email,password) values (?,?,?)");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());
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
	public static ArrayList<UserBean> listuser() {
		ArrayList<UserBean> usersArrayList=new ArrayList<UserBean>();
		try {
			Connection connection=DbConnection.getConnection();
			PreparedStatement pstmt=connection.prepareStatement("select * from user");
//			pstmt.executeQuery();
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
			UserBean userBean=new UserBean();
			userBean.setUserId(rs.getInt("userId"));
			userBean.setFirstName(rs.getString("firstName"));
			userBean.setEmail(rs.getString("email"));
			usersArrayList.add(userBean);
//			rs.next();
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usersArrayList;
	}
	

public static boolean getLogin(String email,String password) {
		boolean status=false; 
		UserBean userBean=new UserBean();
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user where email=? and password=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);	
//			int userId=userBean.getUserId();
//			pstmt.setLong(3, userId);
			ResultSet rs = pstmt.executeQuery();
			status=rs.next();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
public UserBean getUserByEmail(String email) {
	UserBean userBean = null;

	try {
		Connection con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from user where email like ?");
		pstmt.setString(1, email);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {

			userBean = new UserBean();
			userBean.setUserId(rs.getInt("userId"));
			userBean.setFirstName(rs.getString("firstName"));
			userBean.setEmail(rs.getString("email"));
			userBean.setPassword(rs.getString("password"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	return userBean;
}

}
