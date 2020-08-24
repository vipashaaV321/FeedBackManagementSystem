package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from users where userId = ?");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<UserBean> searchUserByName(String searchName) {
		ArrayList<UserBean> users = new ArrayList<UserBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where firstName like ?");
			pstmt.setString(1, searchName);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				UserBean userBean = new UserBean();
				userBean.setUserId(rs.getInt("userId"));
				userBean.setFirstName(rs.getString("firstName"));
				userBean.setEmail(rs.getString("email"));

				users.add(userBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

}
