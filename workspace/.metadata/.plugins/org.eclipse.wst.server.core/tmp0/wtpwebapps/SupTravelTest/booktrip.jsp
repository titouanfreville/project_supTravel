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
		<%@ page language="java" import="com.supinfo.suptravel.dao.TripDAO" %>
		<%@ page language="java" import="java.util.List" %>	
		<form action="BookTrip">
		<% 	TripDAO t = new TripDAO();
			List<String> l = t.listTrips();
			for (String s : l) {
				out.println("<input type=\"submit\" name=\"trip\" value=\""+s+"\"/>");
			}
		%>
		</form>
	</body>
</html>