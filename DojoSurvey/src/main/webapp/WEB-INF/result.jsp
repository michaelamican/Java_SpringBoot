<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="boxy">
			<table>
				<thead>
					<th>Submitted Info</th>
				</thead>
				<tbody>
					<tr>
						<td>Name:</td>
						<td><c:out value="${name}"/></td>
					</tr>
					<tr>
						<td>Dojo Location:</td>
						<td><c:out value="${location}"/></td>
					</tr>
					<tr>
						<td>Favorite Language:</td>
						<td><c:out value="${language}"/></td>
					</tr>
					<tr>
						<td>Comment:</td>
						<td><c:out value="${comment}"/></td>
					</tr>
				</tbody>
			</table>
			<button><a href="/">Go Back</a></button>
		</div>
	</div>
</body>
</html>