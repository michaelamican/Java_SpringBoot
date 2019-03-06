<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="./../css/style.css">
<title>Product</title>
</head>
<body>
	<div id="navbar">
		<ul>
			<li>
				<a href="/logout">Logout</a>
			</li>
			<li>
				<a href="/courses">Home</a>
			</li>
		</ul>
	</div>
	<div id="wrapper">
		<div class="box">
			<h2><c:out value="${course.title}"/></h2>
			<p>Instructor: <c:out value="${course.instructor}"/></p>
			<p>Max: <c:out value="${course.max}"/></p>
		</div>
		<a href="/courses/${course.id}/edit">
				<button>Edit Course</button>
			</a>
			<form:form action="/delete/${course.id}" method="delete" modelAttribute="cpObj">
				<input type="submit" value="Delete Course">
			</form:form>
		<div class="formbox">
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Sign Up Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${enrolled}" var="e">
						<tr>
							<td><c:out value="${e.name}"/></td>
							<td><c:out value="${e.createdAt}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>