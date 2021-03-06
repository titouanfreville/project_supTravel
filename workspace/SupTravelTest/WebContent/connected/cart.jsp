<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<%@ page language="java" import="com.supinfo.suptravel.dao.TripDAO" %>
<%@ page language="java" import="com.supinfo.suptravel.bean.Trip" %>
<%@ page language="java" import="java.util.List" %>	
<%@ page language="java" import="com.supinfo.suptravel.cart.TripCart" %>
<%@ page language="java" import="com.supinfo.suptravel.cart.Item" %>
<%@ page language="java" import="java.util.Vector" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
		<title>Cart</title>
		<link rel='icon' href='favicon.ico' />
    	<link rel='icon' type='image/gif' href='cactusgreen.gif' />
   		 <!-- loading CSS -->
    	<link href='../css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		<jsp:include page="utils/header.jsp" />
		<div class='main'>
			<div class="cart">
				<h1>Your cart</h1>
				<ul>
					<li>
						<span class='name'>Trip Name</span>
						<span class='quantity'>Quantity</span>
					</li>			
					<% 	
						TripCart mycart = (TripCart) session.getAttribute("cart");
						Vector<Item> vit = mycart.getItems();
						for (Item it : vit) {
							Trip t = it.getTrip();
							int q = it.getQuantity();
							out.println("<li>");
							out.println("<span class='name'>"+t.getTripname()+"</span>");
							out.println("<span class='quantity'>"+q+"</span>");
							out.println("</li>");
						}
					%>
				</ul>
				<form action="BookTrip">
					<input type="submit" value="Confirm your trips !"/>
				</form>
			</div>
		</div>
	</body>
</html>