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
		<td><img src="images/logo.png" alt="" style="width:50px;height:50px;"></td>
		<td>
		
			<a href="/GEA/Vendor">Vendor</a>
		 	|
		 	<a href="/GEA/HowToUseSite">How to use this Website</a>
		 	|
		 	<a href="/GEA/AboutThisWebsite">About this Website</a> 
		 	<a href="/GEA/AddBook">Add Book</a>
		 	<a href="/GEA/GeaParentsLibrary">Library</a>
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
			<br>
			<h3>GEA Uniforms</h3>
			<ul>
				<li><a href="/GEA/SellUniform">Sell Uniform</a></li>
				<li><a href="/GEA/SellMultipleUniform">Sell Uniforms</a></li>
				<li><a href="/GEA/BuyUniform">Buy Uniform</a></li>
				<li><a href="/GEA/BuyMultipleUniform">Buy Uniforms</a></li>
			</ul>
			<h3>GEA Textbooks</h3>
			<ul>
				<li><a href="/GEA/SellTextbook">Sell Textbook</a></li>
				<li><a href="/GEA/SellMultipleTextbook">Sell Textbooks</a></li>
				<li><a href="/GEA/BuyTextbook">Buy Textbook</a></li>
				<li><a href="/GEA/BuyMultipleTextbook">Buy Textbooks</a></li>
			</ul>
			<h3>Your Ads</h3>
			<ul>
			<li><a href="/GEA/ViewMyAds?screenCode=ST">Sell Textbooks</a></li>
			<li><a href="/GEA/ViewMyAds?screenCode=SU">Sell Uniform</a></li>
			<li><a href="/GEA/ViewMyAds?screenCode=BT">Buy Textbooks</a></li>
			<li><a href="/GEA/ViewMyAds?screenCode=BU">Buy Uniform</a></li>
			</ul>
			<br>
		</div>
		
		<!-- <div id="right"></div>  -->

	</div>

	<div id="footer" align="center">
  			
		 	<a href="/GEA/SiteFeedback">Feedback on this Website</a> 
		 	|
		 	<a href="/GEA/ContactMe">Contact Me </a>
	</div>
</body>
</html>