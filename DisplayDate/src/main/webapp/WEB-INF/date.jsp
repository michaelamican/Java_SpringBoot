<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/date.js"></script>
<meta charset="UTF-8">
<title>Date</title>
</head>
<body>
<script>

</script>
<div id="wrapper">
	<h3>The current date is:</h3>
	<h1><c:out value="${date}"/></h1>
	<a href="/datetime">Home</a>
	<a href="/time">Time</a>
	<button onclick="dateAlert()">What day is it??</button>
	</div>
</body>
</html>