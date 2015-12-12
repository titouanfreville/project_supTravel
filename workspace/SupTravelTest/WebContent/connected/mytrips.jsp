<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="com.supinfo.suptravel.bean.Trip" %>
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
			<ul>
				<li>
					<span class="name">Trip Name</span>
					<span class="quantity">Quantity booked</span>
				</li>	
				<% 
				ArrayList<Object[]> tlist = (ArrayList<Object[]>) request.getAttribute("ltrip");
				try {
					for (Object[] o : tlist) {	
						Trip t = (Trip) o[0];
						int q = (Integer) o[1];
						out.println("<li><span class='name'>"+t.getTripname()+"</span><span class='quantity'>"+q+"</span></li>");
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