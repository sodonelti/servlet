package com.lti.training.servlet;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.training.day6.collections.InMemoryUserManager;
import com.lti.training.day6.collections.DatabaseUserManager.DatabaseUserManager;




/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.lti")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//reading form data
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
		    DatabaseUserManager mgr = new DatabaseUserManager();
		    String isValidUser = mgr.isValidUser(username,password);
		  
		    
				
			if(isValidUser.equals("true")) {
				
				String rememberMe=request.getParameter("rememberMe");
			   if(rememberMe !=null &&rememberMe.equals("yes")) {
				   //cookie can be stored for some period of time
				   //time is passed in seconds i.e. 60*60 =1hr.
				    String encodedusername = Base64.getEncoder().encodeToString(username.getBytes());
				  	String encodedpassword = Base64.getEncoder().encodeToString(password.getBytes());
				   	Cookie c1=new Cookie("tom",encodedusername);
				   	Cookie c2=new Cookie("jerry",encodedpassword);
				   	c1.setMaxAge(60*60);//1hr
				   	c2.setMaxAge(60*60);//1hr
				   	response.addCookie(c1);
				   	response.addCookie(c2);
			   }
			   response.sendRedirect("welcome.html");
				}
				else 
					  response.sendRedirect("login.html");
		
	
	}

}
