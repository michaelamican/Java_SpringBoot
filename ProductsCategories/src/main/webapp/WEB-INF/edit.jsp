<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<div id="wrapper">
		<div id="navbar">
			<a href="/logout">Logout</a>
			<a href="/">Home</a>
		</div>
		<div class="formbox">
			<form:form action="/update/${product.id}" method="post"  modelAttribute="product" >
				<input type="hidden" name="_method" value="put">
				<p>
					<c:out value="${product.name}" /><c:out value="${product.id}" />
					<label>Name: </label>
					<form:input path="name" type="text" value="${product.name}"/>
					<form:errors path="name"/>
				</p>
				<p>
					<form:label path="price">Price: </form:label>
					<form:input type="number" value="${product.price}" path="price"/>
					<form:errors path="price"/>
				</p>
				<p>
					<form:label path="description">Description: </form:label>
					<form:textarea value="${product.description}" path="description"/>
					<form:errors path="description"/>
				</p>
					<ul>
						<c:forEach items="${product.categories}" var="cp">
							<li><a href="/categories/${cp.id}"><c:out value="${cp.name}"/></a></li>
						</c:forEach>
					</ul>
				<input type="submit" value="Submit">
			</form:form>
		</div>
		<div class="formbox">
			<form:form action="/addCategory" method="post" modelAttribute="cpObj">
				<form:hidden path="product" value="${product.id}"/>
				<form:select path="category">
					<form:option value="0">---</form:option>
					<c:forEach items="${allCats}" var="cat">
						<form:option value="${cat.id}"><c:out value="${cat.name}"/></form:option>
					</c:forEach>
				</form:select>
				<input type="submit" value="Add Category"/>
			</form:form>
		</div>
	</div>
</body>
</html>