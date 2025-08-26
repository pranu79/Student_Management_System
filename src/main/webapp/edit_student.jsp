<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connect.DBConnect"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Student"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="all_css.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container align-center p-3">
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<p class="text-center fs-3">Update Student</p>
						
					<div class="card-body">


						<%
						int id = Integer.parseInt(request.getParameter("id"));
						StudentDao dao = new StudentDao(DBConnect.getConn());
						Student s = dao.getStudentById(id);
						%>

						<form action="editStudent" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control"
									value="<%=s.getName()%>" autofocus>
							</div>


							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control"
									value="<%=s.getDob()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" required name="qualification" class="form-control"
									value="<%=s.getQualification()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Address</label> <input required
									name="address" type="text" class="form-control"
									value="<%=s.getAddress()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									name="email" class="form-control" value="<%=s.getEmail()%>">
							</div>
							<input type="hidden" name="id" value="<%=s.getId()%>">

							<button type="submit" class="btn btn-primary col-12 mx-auto">Update</button>
						</form>




					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>