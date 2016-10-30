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
	<h1>Employee Search</h1>
	</br>
</head>

<body>
	<form:form action="searchEmployee.do" method="post"
		commandName="eidSearchCommand">
		<table>
			<tr>
				<td><form:input path="eid" /></td>
							<td><font color="red" size="3"><form:errors path="eid" />${exception}</font></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>

		</table>
	</form:form>

</body>
</center>
</html>