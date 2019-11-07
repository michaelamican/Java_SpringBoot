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
	<div id="navbar">
		<form:form id="logbar" action="/login" method="post" modelAttribute="loginObj">
				<form:label class="loglabels"  path="email">email</form:label>
				<form:input class="loginputs" type="email" id="knownemail" path="email"/>
				
				<form:label class="loglabels"  path="password">password</form:label>
				<form:password class="loginputs" id="knownpass" path="password"/>
			
				<input class="logsubmit" type="submit" value="log in"/>
				<form:errors class="errors" path="email"/>
				<form:errors class="errors" path="password"/>
		</form:form>
	</div>
	<div id="wrapper">
		<div class="formbox">
		<h2>welcome</h2>
		<hr>
		
			<form:form class="forms" action="/registerUser" method="post" modelAttribute="registerObj">
				<p>
					<form:label class="labels" path="name">name</form:label><br>
					<form:input class="inputs" path="name" type="text" placeholder="first/last" />
				</p>
				<p>
					<form:label class="labels"  path="email">email</form:label><br>
					<form:input class="inputs" type="email" path="email" placeholder="email"/>
				</p>
				<p>
					<form:label class="labels" path="password">password</form:label><br>
					<form:input class="inputs" type="password" path="password" placeholder="8char+" />
				</p>
				<p>
					<form:label class="labels" path="pwConf">pw conf</form:label><br>
					<form:input class="inputs" type="password" path="pwConf"  placeholder="8char+"/>
				</p>
				<input class="submit" type="submit" value="register"/>
				<form:errors class="errors" path="name"/>
				<form:errors class="errors" path="email"/>
				<form:errors class="errors" path="password"/>
				<form:errors class="errors" path="pwConf"/>
			
			</form:form>
		
		</div>
	</div>
</body>