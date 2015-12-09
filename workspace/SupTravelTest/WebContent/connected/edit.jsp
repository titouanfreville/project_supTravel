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
		<header>
			<div class="banner">
				<div class="logo"></div>
				<div class="titles">
					<h1>SupTravel</h1>
					<h2>Trouver votre voyage, depuis votre campus.</h2>
				</div>
				<div class="connected">
					<span> Should span the Campus ID, Name And LastName of the current user.</span>
					<a href="edit.jsp">Should give a page to edit the user profile</a>
					<form action="/Logout">
						<input type="submit" value="Log Out">
					</form>
				</div>
			</div>
			<nav>
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="booktrip.jsp">Book your trip</a></li>
					<li><a href="edit.jsp">Edit your profile</a></li>
					<li>
						<form action="TripsbyUser" method="POST">
							<input class="nobutton" type="Submit" value="Get your trips" />
						</form>
					</li>
					<li>
						<form method="post" action="Trip">
							<label>
								<input type="text" size="30" name="campus" placeholder="Search a trip fromm ... campus" />
							</label>
							<input class="hidden" type="submit">
						</form>
					</li>
				</ul>
			</nav>
		</header>
		<div class="main">
			<form action="Edit" >
				<label>
		    		<span>First Name :</span>
			    	<input type="text" name="name" />
		    	</label>
		    	<label>
		    		<span>Last Name :</span>
			    	<input type="text" name="lastname" />
		    	</label>
		    	<label>
		    		<span>Email :</span>
	                <input type="email" name="email" />
		    	</label>
	            <label>
					<span>Campus :</span>
	                <input type="text" name="campus"/>	
	            </label>
		    	<label>
			    	<span>Password :</span>
			    	<input type="password" name="password" />
		    	</label>
		        <input type="submit" value="Modify" />
			</form>
		</div>
	</body>
</html>