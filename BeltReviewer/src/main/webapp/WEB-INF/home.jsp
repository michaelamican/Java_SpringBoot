<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>Let's Hang!</title>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="navbar">
			<a href="/logout">Logout</a>
		</div>
		<h2>Welcome, <c:out value="${user.username}"/></h2>
			<div id="events">
				<div id="instate">
					<p>Here are some of the events in your state:</p>
					<table>
						<thead>
							<tr>
								<th>Name</th>
								<th>Date</th>
								<th>Time</th>
								<th>Location</th>
								<th>Host</th>
								<th>Action/Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${events}" var="event">
								<tr>
									<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
									<td><c:out value="${event.date}"/></td>
									<td><c:out value="${event.start}"/> - <c:out value="${event.end}"/></td>
									<td><c:out value="${event.city}"/>, <c:out value="${event.state}"/></td>
									<td><c:out value="${event.host}"/></td>
									<td>PLACEHOLDER</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="outstate">
					<p>Here are some of the events in other states:</p>
							<table>
						<thead>
							<tr>
								<th>Name</th>
								<th>Date</th>
								<th>City</th>
								<th>State</th>
								<th>Host</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${events}" var="event">
								<tr>
									<td><c:out value="${event.name}"/></td>
									<td><c:out value="${event.date}"/></td>
									<td><c:out value="${event.location}"/></td>
									<td><c:out value="${event.city}"/></td>
									<td><c:out value="${event.state}"/></td>
									<td>PLACEHOLDER</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		<div id="newevent">	
			<h3>Create an event</h3>
			<div id="form">
				<form:form action="/createEvent" method="post" modelAttribute="newEvent">
					<form:hidden path="host" value="${user.id}"/>
					<p>
						<form:label path="name">Name</form:label>
						<form:input name="name" path="name" placeholder="Event Name"/>
						<form:errors path="name"/>
					</p>
					<p>
						<form:label path="date">Date</form:label>
						<form:input type="date" name="date" path="date"/>
						<form:errors path="date"/>
					</p>
					<p>
						<form:label path="start">Start time</form:label>
						<form:select name="start" path="start">
							<form:option value="9000">--:--</form:option>
							<form:option value="0000">12:00a</form:option>
							<form:option value="0030">12:30a</form:option>
							<form:option value="0100">1:00a</form:option>
							<form:option value="0130">1:30a</form:option>
							<form:option value="0200">2:00a</form:option>
							<form:option value="0230">2:30a</form:option>
							<form:option value="0300">3:00a</form:option>
							<form:option value="0330">3:30a</form:option>
							<form:option value="0400">4:00a</form:option>
							<form:option value="0430">4:30a</form:option>
							<form:option value="0500">5:00a</form:option>
							<form:option value="0530">5:30a</form:option>
							<form:option value="0600">6:00a</form:option>
							<form:option value="0630">6:30a</form:option>
							<form:option value="0700">7:00a</form:option>
							<form:option value="0730">7:30a</form:option>
							<form:option value="0800">8:00a</form:option>
							<form:option value="0830">8:30a</form:option>
							<form:option value="0900">9:00a</form:option>
							<form:option value="0930">9:30a</form:option>
							<form:option value="1000">10:00a</form:option>
							<form:option value="1030">10:30a</form:option>
							<form:option value="1100">11:00a</form:option>
							<form:option value="1130">11:30a</form:option>
							<form:option value="1200">12:00p</form:option>
							<form:option value="1230">12:30p</form:option>
							<form:option value="1300">1:00p</form:option>
							<form:option value="1330">1:30p</form:option>
							<form:option value="1400">2:00p</form:option>
							<form:option value="1430">2:30p</form:option>
							<form:option value="1500">3:00p</form:option>
							<form:option value="1530">3:30p</form:option>
							<form:option value="1600">4:00p</form:option>
							<form:option value="1630">4:30p</form:option>
							<form:option value="1700">5:00p</form:option>
							<form:option value="1730">5:30p</form:option>
							<form:option value="1800">6:00p</form:option>
							<form:option value="1830">6:30p</form:option>
							<form:option value="1900">7:00p</form:option>
							<form:option value="1930">7:30p</form:option>
							<form:option value="2000">8:00p</form:option>
							<form:option value="2030">8:30p</form:option>
							<form:option value="2100">9:00p</form:option>
							<form:option value="2130">9:30p</form:option>
							<form:option value="2200">10:00p</form:option>
							<form:option value="2230">10:30p</form:option>
							<form:option value="2300">11:00p</form:option>
							<form:option value="2330">11:30p</form:option>
						</form:select>
						<form:errors path="start"/>
					</p>
					<p>
						<form:label path="end">End time</form:label>
						<form:select name="end" path="end">
							<form:option value="9000">--:--</form:option>
							<form:option value="0000">12:00a</form:option>
							<form:option value="0030">12:30a</form:option>
							<form:option value="0100">1:00a</form:option>
							<form:option value="0130">1:30a</form:option>
							<form:option value="0200">2:00a</form:option>
							<form:option value="0230">2:30a</form:option>
							<form:option value="0300">3:00a</form:option>
							<form:option value="0330">3:30a</form:option>
							<form:option value="0400">4:00a</form:option>
							<form:option value="0430">4:30a</form:option>
							<form:option value="0500">5:00a</form:option>
							<form:option value="0530">5:30a</form:option>
							<form:option value="0600">6:00a</form:option>
							<form:option value="0630">6:30a</form:option>
							<form:option value="0700">7:00a</form:option>
							<form:option value="0730">7:30a</form:option>
							<form:option value="0800">8:00a</form:option>
							<form:option value="0830">8:30a</form:option>
							<form:option value="0900">9:00a</form:option>
							<form:option value="0930">9:30a</form:option>
							<form:option value="1000">10:00a</form:option>
							<form:option value="1030">10:30a</form:option>
							<form:option value="1100">11:00a</form:option>
							<form:option value="1130">11:30a</form:option>
							<form:option value="1200">12:00p</form:option>
							<form:option value="1230">12:30p</form:option>
							<form:option value="1300">1:00p</form:option>
							<form:option value="1330">1:30p</form:option>
							<form:option value="1400">2:00p</form:option>
							<form:option value="1430">2:30p</form:option>
							<form:option value="1500">3:00p</form:option>
							<form:option value="1530">3:30p</form:option>
							<form:option value="1600">4:00p</form:option>
							<form:option value="1630">4:30p</form:option>
							<form:option value="1700">5:00p</form:option>
							<form:option value="1730">5:30p</form:option>
							<form:option value="1800">6:00p</form:option>
							<form:option value="1830">6:30p</form:option>
							<form:option value="1900">7:00p</form:option>
							<form:option value="1930">7:30p</form:option>
							<form:option value="2000">8:00p</form:option>
							<form:option value="2030">8:30p</form:option>
							<form:option value="2100">9:00p</form:option>
							<form:option value="2130">9:30p</form:option>
							<form:option value="2200">10:00p</form:option>
							<form:option value="2230">10:30p</form:option>
							<form:option value="2300">11:00p</form:option>
							<form:option value="2330">11:30p</form:option>
						</form:select>
						<form:errors path="end"/>
					</p>
					<p>
						<form:label path="city">City</form:label>
						<form:input name="city" path="city" placeholder="City"/>
						<form:errors path="city"/>
					</p>
					<p>
						<form:label path="state">State</form:label>
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
						<form:textarea name="desc" path="desc"/>
						<form:errors path="desc"/>
					</p>
					<p>
							<input type="submit" value="Submit"/>
					</p>
				</form:form>
			</div>	
		</div>
	</div>
</body>
	