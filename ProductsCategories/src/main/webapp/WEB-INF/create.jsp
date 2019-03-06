<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
</head>
<body>
	<div id="wrapper">
		<div id="navbar">
			<a href="/logout">Logout</a>
			<a href="/">Home</a>
		</div>
		<div class="formbox">
			<h2>Product</h2>
			<form:form action="/products/new" method="post" modelAttribute="productObj" >
				<p>
					<label>Name:</label>
					<form:input type="text" path="name"/>
					<form:errors path="name"/>
				</p>
				<p>
					<label>Description: </label>
					<form:textarea path="description"/>
					<form:errors path="description"/>
				</p>
				<p>
					<label>Price: </label>
					$ <form:input type="number" path="price"/>
					<form:errors path="price"/>
				</p>
				<%-- <p>
 					<label>Categories: </label>
 					<form:select path="category">
						<c:forEach items="${product.categories}" var="c">
							<form:option value="${c.id}">
								<c:out value="${c.name}" />
								<a href="/delete/${c.id}">Remove</a>
							</form:option>
						</c:forEach>
					</form:select>
				</p> --%>
				<input type="submit" value="Create Product"/>
			</form:form>
		</div>
		<div class="formbox">
			<form:form action="/categories/new" method="post" modelAttribute="catObj" >
				<p>
					<label>Name:</label>
					<form:input type="text" path="name"/>
					<form:errors path="name"/>
				</p>
				<input type="submit" value="Create Category" />
			</form:form>
		</div>
	</div>

</body>
</html>