<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connect.DBConnect"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title>
<%@ include file="all_css.jsp"%>
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<div class="container p-4 my-4  bg-light">
		<h2 class="text-center">Student Details</h2>

		<div class="row my-4">
		
		<c:if test="${not empty succMsg }">
			<p class="text-center text-success fs-4">${succMsg}</p>
			<c:remove var="succMsg" scope="session" />
		</c:if>

		<c:if test="${not empty errorMsg }">
			<p class="text-center text-danger fs-4">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Full Name</th>
						<th scope="col">DOB</th>
						<th scope="col">Qualification</th>
						<th scope="col">Address</th>
						<th scope="col">Email</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					StudentDao dao = new StudentDao(DBConnect.getConn());
					List<Student> list = dao.getAllStudent();
					for (Student s : list) {
					%>
					<tr>
						<th scope="row"><%=s.getName()%></th>
						<td><%=s.getDob()%></td>
						<td><%=s.getQualification()%></td>
						<td><%=s.getAddress()%></td>
						<td><%=s.getEmail()%></td>
						<td><a href="edit_student.jsp?id=<%=s.getId()%>"
							class="btn btn-primary">Edit</a> <a
							href="delete?id=<%=s.getId()%>" class="btn btn-danger">Delete</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>