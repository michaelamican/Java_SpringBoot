<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<title>shows</title>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="navbar">
		<ul>
			<li>
				<a href="/logout">logout</a>
			</li>
			<li>
				<a href="/shows">home</a>
			</li>
		</ul>
	</div>
	<div id="wrapper">
		
		<h1>welcome, <c:out value="${user.name}"/></h1>
		<div class="topbar">
			<h3>shows</h3>
			<table>
				<thead>
					<tr>
						<th>show title</th>
						<th>network</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${show}" var="s">
						<tr>
							<td><a href="/shows/${s.id}"><c:out value="${s.title}" /></a></td>
							<td><c:out value="${s.network}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/shows/new"><button>add a show</button></a>
		</div>
	</div>
</body>