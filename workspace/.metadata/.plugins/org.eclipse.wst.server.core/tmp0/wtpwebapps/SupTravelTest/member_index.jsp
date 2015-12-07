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
    	<link href='./css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		Welcome to the Register Member General Pannel.
		<%@ page language="java" import="com.supinfo.suptravel.dao.TripDAO" %>
		<%@ page language="java" import="java.util.List" %>	
		List of the currently available trips.	
		<ul>
		<% 	TripDAO t = new TripDAO();
			List<String> l = t.listTrips();
			for (String s : l) {
				out.println("<li>"+s+"</li>");
			}
		%>
		</ul>
		Get trips link to a campus : 
		<form method="post" action="Trip">
			<label>
				<span>Cmpus Name :</span>
				<input type="text" name="campus" value="?"/>
			</label>
				<input type="submit" value = "Find">
		</form>
		<a href="booktrip.jsp">Casse Pied</a>
		<form action="TripsbyUser" method="POST">
			<input class="nobutton" type="Submit" value="Get your trips" />
		</form>
	</body>
</html>