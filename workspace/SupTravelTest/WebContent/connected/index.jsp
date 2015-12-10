<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
		<title></title>
		<link rel='icon' href='favicon.ico' />
    	<link rel='icon' type='image/gif' href='cactusgreen.gif' />
   		 <!-- loading CSS -->
    	<link href='../css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		<jsp:include page="utils/header.jsp" />
		<div class="main">
			<h1>Welcome to the Register Member General Pannel.</h1>
			<%@ page language="java" import="com.supinfo.suptravel.dao.TripDAO" %>
			<%@ page language="java" import="java.util.List" %>	
			<div class="triplist">	
				List of the currently available trips.
				<ul>
					<% 	TripDAO t = new TripDAO();
						List<String> l = t.listTrips();
						for (String s : l) {
							out.println("<li>"+s+"</li>");
						}
					%>
				</ul>
			</div>
			<div class="trip_by_campus_form">
				Get trips link to a campus : 
				<form method="post" action="Trip">
					<label>
						<span>Campus Name :</span>
						<input type="text" name="campus" size="30" placeholder="?"/>
					</label>
					<input type="submit" value = "Find">
				</form>
			</div>
			<div class="booktrip">
				<div class="img"></div>
				<a href="booktrip.jsp">Book your trip</a>
			</div>
			<form action="TripsBooked" method="POST">
				<input class="nobutton" type="Submit" value="Get your trips" />
			</form>
		</div>
	</body>
</html>