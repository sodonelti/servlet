package com.lti.training.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
public static void main(String[] args) {
	Connection conn=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="hr";
		String pass="hr";
		conn=DriverManager.getConnection(url, user, pass);
		System.out.println("connected sucessfuly");
	}
	catch(ClassNotFoundException e) {
		System.out.println("JDBC driver not found");
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		try 
		{
			conn.close();
			}
		catch(Exception e) {
			
		}
	}
}

}
