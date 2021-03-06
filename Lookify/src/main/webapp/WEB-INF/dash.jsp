<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<title>Lookify!</title>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="navbar">
				<a href="/songs">Add New</a> /
				<a href="/top">Top 10</a>
				<form name="search" method="POST" action="/search">
					<input type="search" name="findme" placeholder="Search">
					<input type="submit" value="Search Artists">
				</form>
		</div>
		<div id="box">
			<table>
			<h3>Welcome to the Dashboard!</h3>
				<thead>
					<tr>
						<th>Name</th>
						<th>Rating</th>
						<th>Artist</th>
						<th>Actions</th>
					</tr>
				</thead>
				<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td><c:out value="${song.artist}"/></td>
					<td>
						<form:form action="/songs/delete/${song.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form:form></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
	