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
		<div class="main">
		    <h1>Registration Form</h1>
		    <form action="Register" method="post">
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
					<span>Student ID :</span>
	                <input type="number" name="studentid" size="6" />
	            </label>
	            <label>
					<span>Campus :</span>
	                <input type="text" name="campus"/>	
	            </label>
		    	<label>
			    	<span>Password :</span>
			    	<input type="password" name="password" />
		    	</label>
		    <!-- 	<label>
	                <span>Confirm Password :</span>
	                <input type="password" name="password2" size="30" />
		    	</label> -->
		        <input type="submit" value="Register" />
		    </form>
	    </div>
	</body>
</html>