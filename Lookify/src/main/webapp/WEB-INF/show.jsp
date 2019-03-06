<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<title>${song.title}</title>
<head>
	<script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	
</head>
<body>
	<script>
		$(document).ready(function(){
			$('#edit_me').hide();
			$('#editor').click(function(){
				$('#edit_me').slideDown();
			})
		});
	</script>
	<div id="wrapper">
		<div id="navbar">
				<a href="/songs">Add New</a> /
				<a href="/top">Top 10</a>
				<form name="search" method="POST" action="search">
					<input type="search" placeholder="Search">
					<input type="submit" value="Search Artists">
				</form>
		</div>
		
		<div id="box">
			<h3>${song.title}</h3>
			<table>
				<tbody>
					<tr>
						<th>Artist</th>
						<td><c:out value="${song.artist}"/></td>
					</tr>
					<tr>
						<th>Rating</th>
						<td><c:out value="${song.rating}"/></td>
					</tr>
					<tr>
						<th>Actions</th>
						<td>
						<form action="/songs/delete/${song.id}" method="POST">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form> 
						<button id="editor" value="Edit">Edit</button></td>
				</tbody>
			</table>
			<div id="edit_me">
				<form:form action="/songs/edit/${song.id}" method="POST" modelAttribute="song">
					<input type="hidden" name="_method" value="put">
					<table>
						<tbody>
							<tr>
								<th><form:label path="title">Title</form:label></th>
								<td><form:input type="text" path="title"/><form:errors path="title"/></td>
							</tr>
							<tr>
								<th><form:label path="artist">Artist</form:label></th>
								<td><form:input type="text" path="artist"/><form:errors path="artist"/></td>
							</tr>
							<tr>
								<th>Rating (1-10)</th>
								<td>
									<form:select path="rating">
										<form:option name="rating" value="1">1</form:option>
										<form:option name="rating" value="2">2</form:option>
										<form:option name="rating" value="3">3</form:option>
										<form:option name="rating" value="4">4</form:option>
										<form:option name="rating" value="5">5</form:option>
										<form:option name="rating" value="6">6</form:option>
										<form:option name="rating" value="7">7</form:option>
										<form:option name="rating" value="8">8</form:option>
										<form:option name="rating" value="9">9</form:option>
										<form:option name="rating" value="10">10</form:option>
									</form:select>
									<form:errors path="rating"/>
								</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><input type="submit" value="Update"></td>
							</tr>
						</tbody>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
	