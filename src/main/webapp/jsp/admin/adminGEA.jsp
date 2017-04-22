<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<%@page import="gea.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admin Console</title>
	<link rel="stylesheet" type="text/css" href="css/gea.css"  />
	<script type="text/javascript" src="js/geaScripts.js"></script> 	
</head>

<body>
	<div id="header">
		<table width=100%>
		<tr>
		<td><img src="images/logo.png" alt="Mountain View" style="width:50px;height:50px;">&nbsp; &nbsp;</td>
		<td>
				<a href="/GEA/ShowDbData?tableCode=R">Registered Users</a> &nbsp; &nbsp;
				<a href="/GEA/ShowDbData?tableCode=U">Uniform Ads</a> &nbsp; &nbsp;
				<a href="/GEA/ShowDbData?tableCode=T">Textbook Ads</a> &nbsp; &nbsp;
				<a href="/GEA/ShowDbData?tableCode=L">Library</a> &nbsp; &nbsp;
		</td>
		<td align=right  style="padding-right:40px">
			<% if (session.getAttribute("LoggedUser")!=null) { %>
			    Hi <%= ((gea.model.User)session.getAttribute("LoggedUser")).getName()%>! | <a href="/GEA/adminLogout">Logout </a>
			<% } else { %>
				<a href="/GEA/adminLogin">Login</a> 
			<% } %>
		</td>
		</tr> 
		</table>
	</div>

	<div id="center" class="column"><tiles:insertAttribute name="content" /></div>
	
	<div id="footer" align="center"></div>
	
</body>
</html>