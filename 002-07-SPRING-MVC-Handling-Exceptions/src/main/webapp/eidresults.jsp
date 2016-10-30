<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Exceptions</title>
<center>
	<br>
	<h1>Handling Exceptions in SPRING</h1>
	<h1>Employee Search Results</h1>
	</br>
</head>

<body>

	<table>
		<tr>
			<td>Employee ID :</td>
			<td>${ETO.eid}</td>
		</tr>
		<tr>
			<td>Batch ID :</td>
			<td>${ETO.dpid}</td>
		</tr>
		<tr>
			<td>Employee name :</td>
			<td>${ETO.ename}</td>
		</tr>
		<tr>
			<td>Email ID :</td>
			<td>${ETO.email}</td>
		</tr>
		<tr>
			<td>Phone No :</td>
			<td>${ETO.phone}</td>
		</tr>
	</table>


</body>
</center>
</html>