<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="./../../css/style.css">
<title>Edit</title>
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
		<h1>edit <span class="title">${showTitle}</span></h1>
		<div class="formbox">
			<form:form action="/update/${showId}" method="put" modelAttribute="showObj" >
				<input type="hidden" name="_method" value="put">
				<p>
					<form:label class="labels" path="title">title: </form:label><br>
					<form:input class="inputs" path="title" type="text" value="${showObj.title}"/>
					<form:errors class="errors" path="title"/>
				</p>
				<p>
					<form:label class="labels" path="network">network: </form:label><br>
					<form:input class="inputs" type="text" path="network" value="${showObj.network}"/>
					<form:errors class="errors" path="network"/>
				</p>
				<input class="submit" type="submit" value="submit">
			</form:form>
			<form:form action="/delete/${showId}" method="delete" modelAttribute="sObj">
				<input class="submit" type="submit" value="delete show">
			</form:form>
		</div>
	</div>
</body>
</html>