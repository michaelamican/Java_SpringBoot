<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="boxy">
		<p id="flash"><c:out value="${error}"/></p>
			<form method="POST" action="/submits">
				<table>
					<tbody>
						<tr>
							<td>Your Name:</td>
							<td><input type="text" name="name" placeholder="First/Last"></td>
						</tr>
						<tr>
							<td>Dojo Location:</td>
							<td><select name="location">
								<option value="noVal">Select</option>
								<option value="Berkeley">Berkeley</option>
								<option value="Boise">Boise</option>
								<option value="Chicago">Chicago</option>
								<option value="Dallas">Dallas</option>
								<option value="LosAngeles">Los Angeles</option>
								<option value="Seattle">Seattle</option>
								<option value="SiliconValley">Silicon Valley</option>
								<option value="Tulsa">Tulsa</option>
								<option value="Tysons">Tyson's Corner</option>
								<option value="Online">Online</option>
							</select></td>
						</tr>
						<tr>
							<td>Favorite Language:</td>
							<td><select name='language'>
							<option value="noVal">Select</option>
							<option value="C#">C#</option>
							<option value="Python">Python</option>
							<option value="Java">Java</option>
							<option value="Javascript">Javascript</option>
							<option value="MySQL">MySQL</option>
							<option value="Django">Django</option>
							<option value="Angular">Angular</option>
							<option value="Spring">Spring</option>
							<option value="Other">Other</option>
							</select></td>
						</tr>
						</tbody>
				</table>
				<p>Comment (optional):</p>
				<textarea name="comment"></textarea>
				<input id="submission" type="submit" value="Submit">
			</form>
			<a href="/"><button>Go Back</button></a>
		</div>
	</div>
</body>
</html>