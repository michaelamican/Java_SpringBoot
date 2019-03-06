<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<title>${event.name}</title>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<h2><c:out value="${event.name}"/></h2>
		<div id="box">
			<div id="details">
				<p>Host: <c:out value="${event.host}"/></p>
				<p>Date: <c:out value="${event.date}"/></p>
				<p>Location: <c:out value="${event.city}"/>, <c:out value="${event.state}"/></p>
				<p>People attending: <c:out value="${event.headcount}"/></p>
				<p>
					<form:form action="/join" method="post" name="join">
						<input id="join" type="submit" value="Join!">
					</form:form>
					<form:form action="/remove" method="post" name="remove">
						<input id="noThanks" type="submit" value="Maybe not">
					</form:form>
				</p>
			</div>
			<table>
					<thead>
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td><c:out value="${user.fname}"/> <c:out value="${user.lname}"/></td>
								<td><c:out value="${user.city}"/>, <c:out value="${user.state}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			<div id="messages">
				<h3>Message Wall</h3>
				<div id="messageboard">
					<c:forEach items="${comments}" var="comment">
						<p><c:out value="${comments.username}"/> says: <c:out value="${comments.comment}"/></p>
						<hr>
					</c:forEach>
				</div>
				<p>Add Comment:</p>
				<form:form action="/comment" method="post" modelAttribute="comment">
					<form:hidden path="user" value="${user.id}"/>
					<form:hidden path="event" value="${event.id}"/>
					<form:textarea name="comment"/>
					<form:input type="submit" value="Submit"/>
				</form:form>
			</div>
		</div>
	</div>
</body>