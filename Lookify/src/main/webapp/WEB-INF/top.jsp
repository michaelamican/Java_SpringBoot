<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="box">
			<h3>Top 10</h3>
			<table>
				<thead>
					<tr>
						<th>Rating</th>
						<th>Title</th>
						<th>Artist</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${banana}" var="song">
						<tr>
							<td>${song.rating}</td>
							<td>${song.title}</td>
							<td>${song.artist}</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
			<a href="/dash">Home</a>
		</div>
	</div>
</body>