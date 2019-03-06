<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<title>${song.title}</title>
<head>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	
</head>
<body>
	<div id="wrapper">
		<div id="navbar">
				<a href="/songs">Add New</a>
				<a href="/top">Top 10</a>
				<form name="search" method="POST" action="search">
					<input type="search" placeholder="Search">
					<input type="submit" value="Search Artists">
				</form>
		</div>
		
		<div id="box">
			<div id="artistsbox">	
				<table>
					<c:forEach items="${brujas}" var="artists">
						<tbody>
							<tr>
								<th>${artists.artist}</th>
							<tr>
								<th>Title</th>
								<td><c:out value="${artists.title}"/></td>
							</tr>
							<tr>
								<th>Rating</th>
								<td><c:out value="${artists.rating}"/></td>
							</tr>
							<tr>
								<th>Actions</th>
								<td>
								<form action="/songs/delete/${artists.id}" method="POST">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="Delete">
								</form> 
								<button id="editor" value="Edit">Edit</button></td>
						</tbody>
						</c:forEach>
				</table>
			</div>
			<div id="songsbox">
				<c:forEach items="${cantares}" var="titles">
					<table>
						<tbody>
							<tr>
								<th>Title</th>
								<td><c:out value="${titles.title}"/></td>
							</tr>
							<tr>
								<th>Rating</th>
								<td><c:out value="${titles.rating}"/></td>
							</tr>
							<tr>
								<th>Actions</th>
								<td>
								<form action="/songs/delete/${titles.id}" method="POST">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="Delete">
								</form> 
								<button id="editor" value="Edit">Edit</button></td>
						</tbody>
					</table>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
	