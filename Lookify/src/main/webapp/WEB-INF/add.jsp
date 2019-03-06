<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="box">
			<form:form action="/submit" method="post" modelAttribute="newSong">
			<table>
				<tbody>
					<tr>
						<th><form:label path="title">Title</form:label></th>
						<td><form:input path="title"/><form:errors path="title"/></td>
					</tr>
					<tr>
						<th><form:label path="artist">Artist</form:label></th>
						<td><form:input path="artist"/><form:errors path="artist"/></td>
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
						<td><input type="submit" value="Add Song"></td>
					</tr>
				</tbody>
			</table>
			</form:form>
			<a href="/dash">Go Back</a>
			
		</div>
	</div>
</body>