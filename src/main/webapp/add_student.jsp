<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add student</title>
<%@ include file="all_css.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container align-center p-3">
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<p class="text-center fs-3 mt-3">Add Student</p>

					<c:if test="${not empty succMsg }">
						<p class="text-center text-success fs-4">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty errorMsg }">
						<p class="text-center text-danger fs-4">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>

					<div class="card-body">
						<form action="addStudent" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control" value=""
									autofocus>
							</div>


							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control" value="">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" required name="qualification" class="form-control"
									value="">
							</div>

							<div class="mb-3">
								<label class="form-label">Address</label> <input required
									name="address" type="text" class="form-control" value="">
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									name="email" class="form-control" value="">
							</div>
							<input type="hidden" name="id" value="">

							<button type="submit" class="btn btn-primary col-12 mx-auto">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>