package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/feedback";
		String userName = "root";
		String password = "root";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url,userName,password);
				if(con != null) {
					System.out.println("dbConnected....");
					return con;
			}
		
		} 
		catch (Exception e) {
		e.printStackTrace();	
		}
		return null;
	}
	public static void main(String[] args) {
//		getConnection();
	}
}
