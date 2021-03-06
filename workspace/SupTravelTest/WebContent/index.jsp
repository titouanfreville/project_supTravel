<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<%@ page import="com.supinfo.suptravel.dao.TripDAO"%>
<%@ page import="com.supinfo.suptravel.dao.UserDAO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
		<title>Welcome</title>
		<link rel='icon' href='images/favicon.ico' />
    	<link rel='icon' type='image/png' href='images/favicon.png' />
   		 <!-- loading CSS -->
    	<link href='./css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		<jsp:include page="utils/header.jsp" />
		<div class="main">
			<span class="notconnected">You are not log in the application. Please log in or register to enjoy this app.</span>
			<div class="stats">
				<div>
					<span class="name">
						Number of register users
					</span>
					<span class="number">
						<% 	UserDAO u = new UserDAO();
							Long nu = u.getNumberUser();
							out.println (nu); %>
					</span>
				</div>
				<div>
					<span class="name">Number of trips available</span>
					<span class="number">
					<% 	TripDAO t = new TripDAO();
						Long tu = t.getNumberTrip();
						out.println (tu); %>
					</span>
				</div>
			</div>
		</div>
	</body>
</html>
