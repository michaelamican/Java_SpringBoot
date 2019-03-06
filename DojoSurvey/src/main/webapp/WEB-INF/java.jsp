<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapperjava">
		<div id="boxyjava">
			<table>
				<thead>
					<th class="bright">Submitted Info</th>
				</thead>
				<tbody>
					<tr>
						<td class="bright">Name:</td>
						<td class="bright"><c:out value="${name}"/></td>
					</tr>
					<tr>
						<td class="bright">Dojo Location:</td>
						<td class="bright"><c:out value="${location}"/></td>
					</tr>
					<tr>
						<td class="bright">Favorite Language:</td>
						<td class="bright"><c:out value="${language}"/></td>
					</tr>
					<tr>
						<td class="bright">Comment:</td>
						<td class="bright"><c:out value="${comment}"/></td>
					</tr>
				</tbody>
			</table>
			<button><a class="bright" href="/">Go Back</a></button>
		</div>
	</div>
</body>
</html>