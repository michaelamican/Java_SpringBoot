<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<div id="wrapper">
		<div id="navbar">
			<a href="/logout">Logout</a>
			<a href="/">Home</a>
		</div>
		<div class="box">
			<h1><c:out value="${product.name}"/></h1>
			<p><c:out value="${product.description}"/></p>
			<p><c:out value="$ ${product.price}"/></p>
			<p>
				<ul>
					<c:forEach items="${product.categories}" var="cp">
						<li>
							<a href="/categories/${cp.id}"><c:out value="${cp.name}"/></a>
							
						</li>
					</c:forEach>
				</ul>
			</p>
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
			<a href="/edit/${product.id}">
				<button>Edit Product</button>
			</a>
			<form:form action="/delete/${product.id}" method="delete" modelAttribute="cpObj">
				<input type="submit" value="Delete Product">
			</form:form>
		</div>
			<div class="box">
			<h1><c:out value="${category.name}" /> 
				<a href="/editCat/${category.id}"><button>Edit</button></a>
			</h1>
			<ul>
			<c:forEach items="${category.products}" var="p">
				<li><a href="/products/${p.id}"><c:out value="${p.name}"/></a></li>
			</c:forEach>
				</ul>
		</div>
	</div>
	
</body>
</html>