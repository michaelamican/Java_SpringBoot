<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<title>login</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div class="formbox">
		<h2>welcome</h2>
		<hr>
		
			<form:form class="forms" action="/registerUser" method="post" modelAttribute="userObj">
				<p>
					<form:label for="name" path="name" placeholder="first/last">name</form:label><br>
					<form:input  path="name" type="text" />
				</p>
				<p>
					<form:label for="email" path="email" placeholder="email">email</form:label><br>
					<form:input type="email" path="email" />
				</p>
				<p>
					<form:label for="password" path="password" placeholder="8char+">password</form:label><br>
					<form:input type="password" path="password" />
				</p>
				<p>
					<form:label for="pwConf" path="pwConf" placeholder="8char+">pw conf</form:label><br>
					<form:input type="password" path="pwConf" />
				</p>
				<input class="submit" type="submit" value="register"/>
				<form:errors path="name"/>
				<form:errors path="email"/>
				<form:errors path="password"/>
				<form:errors path="pwConf"/>
			
			</form:form>
		
		</div>
		<div class="formbox">
			<h2>login</h2>
			<hr>
			<form class="forms" action="/login" method="post">
				<p>
					<label type="email" for="email">email</label> <br> 
					<form:input type="email" path="email" id="email"/>
				</p>
				<p>
					<label for="password">password</label><br>
					<input type="password" id="password"/>
				</p>
				<input class="submit" type="submit" value="login"/>
				<p><c:out value="${error}" /></p>
			</form>
			
		</div>
	</div>
</body>