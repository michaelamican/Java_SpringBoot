<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
	<div id="wrapper">
		<h2>What is the code?</h2><hr>
		<form method="POST" name="form" action="bushibushi">
			<input type="text" name="code" placeholder="hint it's bushido">
			<input id=button type="submit" value="Try Code">
		</form>
		<p id="flash"><c:out value="${error}"/></p>
	</div>
</body>
</html>