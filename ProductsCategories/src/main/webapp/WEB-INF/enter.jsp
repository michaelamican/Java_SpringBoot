<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<title>Login</title>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<h2>Welcome</h2>
		<fieldset id="register">
			<legend>New user?</legend>
			<form:form action="/registerUser" method="post" modelAttribute="newUser">
					<form:label for="email" path="email">Email</form:label>
					<form:input type="email" path="email"/><form:errors path="email"/>
				</p>
				<p>
					<form:label for="password" path="password">Password</form:label>
					<form:input type="password" path="password"/><form:errors path="password"/>
				</p>
				<p>
					<form:label for="pwConf" path="pwConf">PW Conf</form:label>
					<form:input type="password" path="pwConf"/><form:errors path="pwConf"/>
				</p>
				<input type="submit" value="Register"/>
			</form:form>
		</fieldset>
		<fieldset id="login">
			<legend>Login</legend>
			<form action="/login" method="post">
				<p><c:out value="${error}" /> </p>
				<p>
					<label for="email">Email</label>
					<input type="email" name="email"/>
				</p>
				<p>
					<label for="password">Password</label>
					<input type="password" name="password"/>
				</p>
				<input type="submit" value="Login" />
			</form>
		</fieldset>
	</div>
</body>