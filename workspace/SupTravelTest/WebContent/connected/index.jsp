<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>    
<%@ page language="java" import="com.supinfo.suptravel.dao.TripDAO" %>
<%@ page language="java" import="java.util.List" %>	
<%@ page language="java" import="org.json.JSONArray" %>
<%@ page language="java" import="org.json.JSONObject" %>
<%@ page language="java" import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
		<title>Welcome :: connected</title>
		<link rel='icon' href='favicon.ico' />
    	<link rel='icon' type='image/gif' href='cactusgreen.gif' />
   		 <!-- loading CSS -->
    	<link href='../css/stylesheets/style.css' rel='stylesheet'>
	</head>
	<body>
		<jsp:include page="utils/header.jsp" />
		<div class="main">
			<h1>Welcome to the Register Member General Pannel.</h1>
			<div class="welcomme">
			<%  Boolean test = (Boolean) session.getAttribute("new_user");
				if (test != null && test) {
					int id = (int) session.getAttribute("campus_id");
					String name = (String)session.getAttribute("name");
					String lastname= (String)session.getAttribute("lastname");
					out.println("Welcomme " + name + "-" + id + "-" + lastname);
					out.println("<span>We are happy to welcome you on this small app.");
					session.setAttribute("new_user",false);
				}
			%>
			</div>
			<div class="booked">
				<%  
					Boolean booked = (Boolean) session.getAttribute("booked");
					if (booked != null && booked) {
						out.println("Thanks for your reservation ! ");
								
					}	
				%>
			</div>
			<div class="tripbox">
				<div class="triplist">	
					List of the currently available trips.
					<ul>
						<% 
							JSONObject gjson = (JSONObject) session.getAttribute("tripljson");
							JSONObject tjson = (JSONObject) gjson.get("campus");
							JSONObject ljson = new JSONObject();
							Iterator<?> keys = tjson.keys();
							while( keys.hasNext() ) {
							    String key = (String)keys.next();
							    if ( tjson.get(key) instanceof JSONObject ) {
							    	ljson = (JSONObject) tjson.get(key);
									JSONArray ntlist = (JSONArray)ljson.get("trips");
									try {
										for (int i=0; i<ntlist.length(); i++) {	
											out.println("<li>"+ntlist.getString(i)+"</li>");
										}
									} catch (Exception e) {
										System.out.println(e);
										out.println("j'ai un pb, je pb.... Je suis con, j'm'appelle java.");
									}
									ljson = new JSONObject();
							    }
							}
						%>
					</ul>
					<a href="../rest/list/">Get a JSON of all the trip</a>
				</div>
				<div class="trip_by_campus_form">
					<span>Get trips link to a campus :</span> 
					<form method="post" action="FindRest">
						<label>
							<span>Campus Name :</span>
							<input type="text" name="campus" size="30" placeholder="?" required/>
						</label>
						<input type="submit" value = "Find">
					</form>
				</div>
			</div>
			
			<div class="booktrip">
				<div class="img"></div>
				<a href="booktrip.jsp">Book your trip</a>
			</div>
			<form action="TripsBooked" method="POST">
				<input class="nobutton" type="Submit" value="Get your trips" />
			</form>
			<a href="../rest/campus">Get json of trip organised by campus.</a>
		</div>
	</body>
</html>