package com.main.sanaltur.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SanalJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/sanal_tur?useSSLL=false";
		String user = "sanaltur";
		String pass = "sanaltur";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			
			System.out.println("Connection successful!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
