<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="org.json.JSONArray" %>
<%@ page language="java" import="org.json.JSONObject" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
		<title>Get the trips from campus ...</title>
		<link rel='icon' href='favicon.ico' />
    	<link rel='icon' type='image/gif' href='cactusgreen.gif' />
   		 <!-- loading CSS -->
    	<link href='../css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		<jsp:include page="utils/header.jsp" />
		<div class="main">
			<span>
				 <%
					JSONObject tjson = (JSONObject) session.getAttribute("tripincampus");
					String campus = (String) session.getAttribute("campsearch");
					out.println("List of trips proposed by "+campus+ " campus :");
				%>
			</span>
			<ul>
			<% 
				JSONArray ntlist = (JSONArray)tjson.get(campus);
				try {
					for (int i=0; i<ntlist.length(); i++) {	
						out.println("<li>"+ntlist.getString(i)+"</li>");
					}
				} catch (Exception e) {
					System.out.println(e);
					out.println("j'ai un pb, je pb.... Je suis con, j'm'appelle java.");
				}
			%>
			</ul>
		</div>
	</body>
</html>