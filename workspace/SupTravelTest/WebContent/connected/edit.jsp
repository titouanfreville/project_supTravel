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
					<form action="Logout">
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
								<input type="text" size="30" name="campus" value="Search a trip fromm ... campus" />
							</label>
							<input class="hidden" type="submit">
						</form>
					</li>
				</ul>
			</nav>
		</header>
		<div class="main">
			<form action="Edit" method="POST" >
			<%@ page language="java" import="com.supinfo.suptravel.bean.User" %>	
			<%@ page language="java" import="com.supinfo.suptravel.dao.UserDAO" %>	
			<%
			UserDAO udao = new UserDAO();
			User u = udao.getUserObject((int) session.getAttribute("user_id")) ;
			String name = null;
			String lastname = null;
			String campus = null;
			String mail = null;
			String pass = null;
			String sid = null;
			try {
        		name = u.getName();
        		lastname = u.getLastname();
        		System.out.println("In JSP " + lastname + "//////"+ u.getLastname());
        		campus= u.getCampus();
        		mail= u.getEmail();
        		pass= u.getPassword();
        		sid= Integer.toString(u.getStudentid());
			} catch (Exception e) {
				System.out.println(e);
				out.println("j'ai un pb, je pb.... Je suis con, j'm'appelle java.");
			}
			%>
				<label>
		    		<span>Student ID :</span>
		    		<%  
		    			out.println("<input disabled type=\"text\" value=\""+ sid +"\"/>");
		    		%>
		    	</label>
				<label>
		    		<span>First Name :</span>
			    	<%  
		    			out.println("<input type=\"text\" name=\"name\" value=\""+ name +"\"/>");
		    		%>
		    	</label>
		    	<label>
		    		<span>Last Name :</span>
		    		<%  
		    			out.println("<input  type=\"text\" name=\"lastname\" value=\""+ lastname +"\"/>");
		    		%>
		    	</label>
		    	<label>
		    		<span>Email :</span>
		    		<%  
		    			out.println("<input type=\"email\" name=\"mail\" value=\""+ mail +"\"/>");
		    		%>
		    	</label>
	            <label>
					<span>Campus :</span>
		    		<%  
		    			out.println("<input type=\"text\" name=\"campus\" value=\""+ campus +"\"/>");
		    		%>	
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