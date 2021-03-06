<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
		<title>Register</title>
		<link rel='icon' href='favicon.ico' />
    	<link rel='icon' type='image/gif' href='cactusgreen.gif' />
   		 <!-- loading CSS -->
    	<link href='./css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		<jsp:include page="utils/header.jsp" />
		<div class="main">
		    <h1>Registration Form</h1>
		    <form action="Register" method="post">
		    	<label>
		    		<span>First Name :</span>
			    	<input type="text" name="name" required/>
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
					<span>Student ID (Campus Booster):</span>
					<%  Boolean test = (Boolean) request.getAttribute("id_exist");
						if (test != null && test) {
							out.println("<script>window.alert('This ID is already in use. Please enter another one')</script>");
							out.println("<input class='error' type='number' name='studentid' size='6' placeholder='ID already in use' required invalid/>");
						} else {
							out.println("<input type='number' name='studentid' size='6' required />");
						}
					%>
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
		    <a href="index.jsp"><button>Back to home</button></a>
	    </div>
	</body>
</html>