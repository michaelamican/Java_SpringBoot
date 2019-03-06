<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="./../css/style.css">

<title>create</title>
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
		<h1>create a show</h1>
		<div class="formbox">
			<form:form action="/create" method="post"  modelAttribute="showObj" >
				<p>
					<form:label path="title">title: </form:label><br>
					<form:input path="title" type="text"/>
					<form:errors path="title"/>
				</p>
				<p>
					<form:label path="network">network: </form:label><br>
					<form:input type="text" path="network"/>
					<form:errors path="network"/>
				</p>
				<input type="submit" value="submit">
			</form:form>
		</div>
	</div>
</body>
</html>