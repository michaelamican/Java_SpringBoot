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
			<div id="navbar"><a id="right" href="/dash">Dashboard</a></div>
			<h3>Songs!</h3>
			<table>
				<tbody>
					<tr>
						<th>Title</th>
						<td><c:out value="${song.title}"/></td>
					</tr>
					<tr>
						<th>Artist</th>
						<td><c:out value="${song.artist}"/></td>
					</tr>
					<tr>
						<th>Rating (1-10)</th>
						<td><c:out value="${song.rating}"/></td>
					</tr>
					<tr>
						<td><a href="/songs/delete/${song.id}">Delete</a> / <a href="/songs/edit/${song.id}">Edit</a></td>
					</tr>
				</tbody>
			</table>
			<a href="/dash">Dashboard</a> / <a href="/">Index</a>
		</div>
	</div>
</body>