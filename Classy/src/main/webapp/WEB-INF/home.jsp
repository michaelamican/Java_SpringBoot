<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<title>Login</title>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
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
		
		<h1>Welcome, <c:out value="${user.name}"/></h1>
		<div class="topbar">
			<h3>Courses</h3>
			<table>
				<thead>
					<tr>
						<th>Courses</th>
						<th>Instructor</th>
						<th>Signups</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${course}" var="c">
						<tr>
							<td><a href="/courses/${c.id}"><c:out value="${c.title}" /></a></td>
							<td><c:out value="${c.instructor}" /></td>
							<td><c:out value="${c.max}" /></td>
							<td>
								<form:form action="/enroll" method="post" modelAttribute="eObj">
									<form:hidden path="user" value="${user.id}" />
									<form:hidden path="course" value="${c.id}" />
									<input class="submit" type="submit" value="Add" />
								</form:form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/courses/new"><button>Add a course</button></a>
		</div>
	</div>
</body>