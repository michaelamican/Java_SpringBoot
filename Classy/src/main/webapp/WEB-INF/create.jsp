<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="./../css/style.css">

<title>Edit</title>
</head>
<body>
	<div id="navbar">
		<ul>
			<li>
				<a href="/logout">Logout</a>
			</li>
			<li>
				<a href="/courses">Home</a>
			</li>
		</ul>
	</div>
	<div id="wrapper">
		<h1>Create a course</h1>
		<div class="formbox">
			<form:form action="/create" method="post"  modelAttribute="courseObj" >
				<input type="hidden" name="_method" value="${user.id}">
				<p>
					<label>Name: </label>
					<form:input path="title" type="text" value="${course.title}"/>
					<form:errors path="title"/>
				</p>
				<p>
					<form:label path="instructor">Instructor: </form:label>
					<form:input type="text" path="instructor"/>
					<form:errors path="instructor"/>
				</p>
				<p>
					<form:label path="max">Capacity: </form:label>
					<form:input type="number" path="max"/>
					<form:errors path="max"/>
				</p>
				<input type="submit" value="Submit">
			</form:form>
		</div>
	</div>
</body>
</html>