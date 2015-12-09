<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
		<title>SupTravel :: Welcome</title>
		<link rel='icon' href='favicon.ico' />
    	<link rel='icon' type='image/gif' href='cactusgreen.gif' />
   		 <!-- loading CSS -->
    	<link href='./css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		<header>
			<div class="banner">
				<div class="logo"></div>
				<div class="titles">
					<h1>SupTravel</h1>
					<h2>Trouver votre voyage, depuis votre campus.</h2>
				</div>
				<div class="connectic">
					<span>login</span>
					<form method="post" action="Login">
						<label>
							<span> User :</span>
							<input type="text" name="name" />
						</label>
						<label>
							<span> Password :</span>
							<input type="password" name="password" />
						</label>
						<div>
							<input type="submit" value="OK"/>
							<button>
								<a href="register.jsp">Register</a>
							</button>
						</div>
					</form>
				</div>
			</div>
		</header>
		<div class="main">
			<span>You are not log in the application. Please log in or register to enjoy this app.</span>
			<div class="stats">
				<div>
					<span>
						Number of register users
					</span>
					<span>
						<%@ page import="com.supinfo.suptravel.dao.UserDAO"%>
						<% 	UserDAO u = new UserDAO();
							Long nu = u.getNumberUser();
							out.println (nu); %>
					</span>
				</div>
				<div>
					<span>Number of trips available</span>
					<span>
						<%@ page import="com.supinfo.suptravel.dao.TripDAO"%>
					<% 	TripDAO t = new TripDAO();
						Long tu = t.getNumberTrip();
						out.println (tu); %>
					</span>
				</div>
			</div>
		</div>
	</body>
</html>
