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
		<div class="main">
			 <form action="AddTrip" method="post">
			    	<label>
			    		<span>Name :</span>
				    	<input type="text" name="name" />
			    	</label>
			    	<label>
			    		<span>Campus :</span>
				    	<input type="text" name="campus" />
			    	</label>
			    	<input type="submit" value="add" />
			    </form>
		  </div>
	</body>
</html>