<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<title>Login</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div class="formbox">
		<h2>Welcome</h2>
		
			<form:form class="forms" action="/registerUser" method="post" modelAttribute="userObj">
				<p>
					<form:label for="name" path="name">Name     </form:label>
					<form:input  path="name" type="text" />
				</p>
				<p>
					<form:label for="email" path="email">Email   </form:label>
					<form:input type="email" path="email" />
				</p>
				<p>
					<form:label for="password" path="password">Password </form:label>
					<form:input type="password" path="password" />
				</p>
				<p>
					<form:label for="pwConf" path="pwConf">PW Conf   </form:label>
					<form:input type="password" path="pwConf" />
				</p>
				<input class="submit" type="submit" value="Register"/>
				<form:errors path="name"/>
				<form:errors path="email"/>
				<form:errors path="password"/>
				<form:errors path="pwConf"/>
			
			</form:form>
		
		</div>
		<div class="formbox">
			<h2>Login</h2>
	
			<form:form class="forms" action="/login" method="post" modelAttribute="userObj">
				<p>
					<form:label for="email" path="email">Email</form:label>   
					<form:input type="email" path="email"/>
				</p>
				<p>
					<form:label for="password" path="password">Password</form:label>
					<form:input type="password" path="password"/>
				</p>
				<input class="submit" type="submit" value="Login"/>
				<form:errors path="email"/>
				<form:errors path="password"/>
			</form:form>
			
		</div>
	</div>
</body>