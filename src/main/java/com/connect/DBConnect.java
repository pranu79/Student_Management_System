package com.connect;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;



public class DBConnect {

	private static Connection conn;
	 

	public static Connection getConn() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		

	            // Create connection
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","password");


		} catch (Exception e) {
			e.printStackTrace();
		}


		return conn;
	}

}
