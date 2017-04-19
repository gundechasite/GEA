<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<%@page import="gea.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>GEA Parents Portal</title>
	<link rel="stylesheet" type="text/css" href="css/gea.css"  />
	<script type="text/javascript" src="js/gea.js"></script> 	
</head>

<body>
	<div id="header">
		<table width=100%>
		<tr>
		<td><img src="images/logo.png" alt="" style="width:40px;height:40px;"></td>
		<td>
			<a href="/GEA/selectClassSubject">Tests</a>&nbsp;
		 	|&nbsp;
			<a href="/GEA/LibraryReadme"> Library</a>&nbsp;
		 	|&nbsp;
		 	<a href="/GEA/BuySellTextbookReadme">Textbooks</a>&nbsp;
		 	|&nbsp;
		 	<a href="/GEA/BuySellUniformReadme">Uniforms</a>
		 	
		 	
		</td>
		<td align=right  style="padding-right:40px">
			
			<% if (session.getAttribute("LoggedUser")!=null) { %>
			    Hi <%= ((gea.model.User)session.getAttribute("LoggedUser")).getName()%>! | <a href="/GEA/Logout">Logout </a>
			<% } else { %>
				<a href="/GEA/HomePage">Home</a>
				| 
				<a href="/GEA/Login">Login</a> 
				|  
				<a href="/GEA/Signup">Signup</a>
			<% } %>
		</td>
		</tr> 
		</table>
	</div>

	<div id="container">

		<div id="center" class="column"><tiles:insertAttribute name="content" /></div>

		<div id="left" class="column">
			<tiles:insertAttribute name="leftNav"  ignore="true"/></div>
		</div>
		
		<!-- <div id="right"></div>  -->

	</div>

	<div id="footer" align="center">
	 	<a href="/GEA/ContactMe">Contact Me </a>
	</div>
</body>
</html>