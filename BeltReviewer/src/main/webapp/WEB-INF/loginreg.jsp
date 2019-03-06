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
				<p>
					<form:label for="fname" path="fname">First Name</form:label>
					<form:input type="text" path="fname"/><form:errors path="fname"/>
				</p>
				<p>
					<form:label for="lname" path="lname">Last Name</form:label>
					<form:input type="text" path="lname"/><form:errors path="lname"/>
				</p><p>
					<form:label for="city" path="city">City</form:label>
					<form:input type="text" path="city" id="city"/><form:errors path="city"/>
				</p>
				<p>
					<form:label for="state" path="state">State</form:label>
					<form:select name="state" path="state">
						<form:option value="noVal">--</form:option>
							<form:option value="AL">AL</form:option>
							<form:option value="AK">AK</form:option>
							<form:option value="AR">AR</form:option>	
							<form:option value="AZ">AZ</form:option>
							<form:option value="CA">CA</form:option>
							<form:option value="CO">CO</form:option>
							<form:option value="CT">CT</form:option>
							<form:option value="DC">DC</form:option>
							<form:option value="DE">DE</form:option>
							<form:option value="FL">FL</form:option>
							<form:option value="GA">GA</form:option>
							<form:option value="HI">HI</form:option>
							<form:option value="IA">IA</form:option>	
							<form:option value="ID">ID</form:option>
							<form:option value="IL">IL</form:option>
							<form:option value="IN">IN</form:option>
							<form:option value="KS">KS</form:option>
							<form:option value="KY">KY</form:option>
							<form:option value="LA">LA</form:option>
							<form:option value="MA">MA</form:option>
							<form:option value="MD">MD</form:option>
							<form:option value="ME">ME</form:option>
							<form:option value="MI">MI</form:option>
							<form:option value="MN">MN</form:option>
							<form:option value="MO">MO</form:option>	
							<form:option value="MS">MS</form:option>
							<form:option value="MT">MT</form:option>
							<form:option value="NC">NC</form:option>	
							<form:option value="NE">NE</form:option>
							<form:option value="NH">NH</form:option>
							<form:option value="NJ">NJ</form:option>
							<form:option value="NM">NM</form:option>			
							<form:option value="NV">NV</form:option>
							<form:option value="NY">NY</form:option>
							<form:option value="ND">ND</form:option>
							<form:option value="OH">OH</form:option>
							<form:option value="OK">OK</form:option>
							<form:option value="OR">OR</form:option>
							<form:option value="PA">PA</form:option>
							<form:option value="RI">RI</form:option>
							<form:option value="SC">SC</form:option>
							<form:option value="SD">SD</form:option>
							<form:option value="TN">TN</form:option>
							<form:option value="TX">TX</form:option>
							<form:option value="UT">UT</form:option>
							<form:option value="VT">VT</form:option>
							<form:option value="VA">VA</form:option>
							<form:option value="WA">WA</form:option>
							<form:option value="WI">WI</form:option>	
							<form:option value="WV">WV</form:option>
							<form:option value="WY">WY</form:option>
					</form:select>
					<form:errors path="state"/>
				</p>
				<p>
					<form:label for="username" path="username">Username</form:label>
					<form:input path="username"/><form:errors path="username"/>
				</p>
				
				<p>
					<form:label for="email" path="email">Email</form:label>
					<form:input type="email" path="email"/><form:errors path="email"/>
				</p>
				<p>
					<form:label for="password" path="password">Password</form:label>
					<form:input type="password" path="password"/><form:errors path="password"/>
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