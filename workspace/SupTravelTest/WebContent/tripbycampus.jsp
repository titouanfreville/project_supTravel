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
		<ul>
		<%@ page language="java" import="java.util.ArrayList" %>	
		<% 
		ArrayList<String> tlist = (ArrayList<String>) request.getAttribute("ltrip");
		try {
			for (String s : tlist) {	
				out.println("<li>"+s+"</li>");
			}
		} catch (Exception e) {
			System.out.println(e);
			out.println("j'ai un pb, je pb.... Je suis con, j'm'appelle java.");
		}
		%>
		</ul>
	</body>
</html>