<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<%@ page language="java" import="com.supinfo.suptravel.bean.User" %>	
<%@ page language="java" import="com.supinfo.suptravel.dao.UserDAO" %>	
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
		<jsp:include page="utils/header.jsp" />
		<div class="main">
			<span>	
				<%  Boolean test = (Boolean) request.getAttribute("modify");
					if (test != null && test) {
						out.println("Your information have been modify.");
					}
				%>
			</span>
			<form action="Edit" method="POST" >
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
		    		<%  
		    			out.println("<input type=\"password\" name=\"password\" value=\""+ pass +"\"/>");
		    		%>	
		    	</label>
		        <input type="submit" value="Modify" />
			</form>
		</div>
	</body>
</html>