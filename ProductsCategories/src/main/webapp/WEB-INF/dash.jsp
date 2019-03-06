<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<div id="wrapper">
		<div id="navbar">
			<a href="/logout">Logout</a>
		</div>
		<div class="buttons">
			<a href="/createProduct"><button>New Product</button></a>
		</div>
		<div class="box">
			<h1>Products</h1>
			<c:forEach items="${product}" var="p">
			<p>
				<a href="/products/${p.id}"><c:out value="${p.name}"/></a>
			</p>
			</c:forEach>
		</div>
		<div class="box">
			<h1>Categories</h1>
			<ul>
				<c:forEach items="${category}" var="c">				
					<li><c:out value="${c.name}"/></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>