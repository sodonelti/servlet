package com.lti.training.day6.collections.DatabaseUserManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.training.day6.collections.User;





public class DatabaseUserManager {
	
	 
	             public String isValidUser(String username,String password) {
	            	
	        	Connection conn=null;
				PreparedStatement stmt=null;
				ResultSet rs=null;
		
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
						
						String sql="select * from TBL_USER where username=? and password=?";
						stmt=conn.prepareStatement(sql);
						
						stmt.setString(1, username);
						stmt.setString(2, password);
						rs=stmt.executeQuery();
						String result="";
						
					if(rs.next()) {
							result=rs.getString(3);
						}
								return result;
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
					return null;
		
	        }
	             }

	
	            	 
	        
	
	
	
	
	

