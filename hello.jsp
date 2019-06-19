<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HELLO</title>
</head>
<body>
<%  //scriptlet in jsp (a piece of JAVA code)
String str = "Hello Everyone";
Date d= new Date();
%>

<h1><%= str %></h1>
<h2>Today's date is <%= d %></h2>

<center>
		<%
		  		for(int i=1;i<=6;i++){
		%>
				<font size="<%= i %>" >HELLO WORLD !</font><br />
				<%
						}
				%>
</center>

</body>
</html>