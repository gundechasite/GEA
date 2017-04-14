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
	<div id="container">
		<div id="center" class="column"><tiles:insertAttribute name="content" /></div>
	</div>
</body>
</html>