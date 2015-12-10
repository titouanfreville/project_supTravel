<header>
	<div class="banner">
		<div class="logo"></div>
		<div class="titles">
			<h1>SupTravel</h1>
			<h2>Trouver votre voyage, depuis votre campus.</h2>
		</div>
		<div class="connected">
			<span>
				<%
					int id = (int) session.getAttribute("campus_id");
					out.println("Your id :"+id);
				%> 
			</span>
			<a href="edit.jsp">Edit your profile</a>
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
				<form action="TripsBooked" method="POST">
					<input class="nobutton" type="Submit" value="Get your trips" />
				</form>
			</li>
			<li>
				<form method="post" action="Trip">
					<label>
						<input type="text" size="30" name="campus" placeholder="Search a trip fromm ... campus" />
					</label>
					<input class="hidden" type="submit">
				</form>
			</li>
		</ul>
	</nav>
</header>