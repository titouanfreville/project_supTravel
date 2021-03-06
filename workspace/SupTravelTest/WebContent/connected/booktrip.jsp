<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<%@ page language="java" import="com.supinfo.suptravel.dao.TripDAO" %>
<%@ page language="java" import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
		<title>Book trips :)</title>
		<link rel='icon' href='favicon.ico' />
    	<link rel='icon' type='image/gif' href='cactusgreen.gif' />
   		 <!-- loading CSS -->
    	<link href='../css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		<jsp:include page="utils/header.jsp" />
		<div class="main">	
			<h1>Select the trip you want to book :)</h1>
			<span>You can only take 10 places for a trip.</span>
			<form class="book" action="AddtoCart" method="POST">
				<select name="trips">
				<% 	TripDAO t = new TripDAO();
					List<String> l = t.listTrips();
					for (String s : l) {
						out.println("<option value=\""+s+"\">"+s+"</option>");
					}
				%>
				</select>
				<input type="number" name="quant" min="1" max="10" placeholder="Number of travel you want (1 to 10)"/>
				<input type="submit" value="Add to Cart" />
			</form>
		</div>
	</body>
</html>