<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/time.js"></script>
<title>Insert title here</title>
</head>
<body>
<script>
button.onclick(timeAlert());
</script>
<div id="wrapper">
	<h3>The current time is:</h3>
	<h1><c:out value="${time}"/></h1>
	<a href="/datetime">Home</a>
	<a href="/date">Date</a>
	<button onclick="timeAlert()">What time is it??</button>
	</div>
</body>
</html>