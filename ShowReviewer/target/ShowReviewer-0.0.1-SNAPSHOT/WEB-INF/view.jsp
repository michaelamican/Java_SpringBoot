<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="./../css/style.css">
<title>show</title>
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
		<div class="box">
			<h2 class="title">${show.title}</h2>
			<h3 class="title">network: ${show.network}</h3>
			<a href="/shows/${show.id}/edit"><button class="submit centered">edit show</button></a>
			<hr>
			<h2>leave a rating: </h2>
		    <form:form action="/rate" method="post" modelAttribute="rObj">
		        <input class="submit centered" type="submit" value="rate" /><br>
		        <form:hidden path="user" value="${user.id}" />
		        <form:hidden path="show" value="${show.id}" />
		        <form:select class="inputs" path="rating">
		            <form:option name="rating" value="0">--</form:option>
		            <form:option name="rating" value="1">1</form:option>
		            <form:option name="rating" value="2">2</form:option>
		            <form:option name="rating" value="3">3</form:option>
		            <form:option name="rating" value="4">4</form:option>
		            <form:option name="rating" value="5">5</form:option>
		        </form:select>
		        <form:errors path="rating"/>
		    </form:form>

		</div>
	</div>
</body>
</html>