<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<title>Search</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="navbar">
			<p>Songs by artist: <c:out value="${artist}"/>
				<form name="search" method="POST">
					<input type="search" placeholder="<c:out value='${artist}'/>">
					<input type="submit" value="Search Artists">
				</form>
				<a href="/dash">Dashboard</a>
			</p>
		</div>
		<div id="box">
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Rating</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${artist.id.song}" var="song">
					<tr>
						<td><c:out value="${song.title}"/></td>
						<td><c:out value="${song.rating}"/></td>
						<td>
							<a href="/delete/${song.id}">Delete</a> / 
							<a href="/songs/${song.id}">View</a> / 
							<a href="/songs/${song.id}/edit">Edit</a>
						</td>
					</tr>
					</c:forEach>						
				</tbody>
			</table>
		</div>
	</div>
</body>