<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
<title>SupTravel :: Welcome</title>
<link rel='icon' href='favicon.ico' />
<link rel='icon' type='image/gif' href='cactusgreen.gif' />
<!-- loading CSS -->
<link href='./css/stylesheets/style.css' rel='stylesheet'>
</head>
<body>
<header>
  <div class="banner"> </div>
  <div class="logo">SUPTRAVEL</div>
</header>
<div class="contenu">
  <div class="titles">
    <h2>Trouver votre voyage, depuis votre campus.</h2>
  </div>
  <div class="connectic">
  <div class="formulaire">
    <table>
        <tr>
      
        <td class="droite">
      
      <form method="post" action="Login">
          <label>
             Student ID :
          </td>
        
        <td><input class="log" type="number" name="id" />
          </label>
          </td>
          </tr>
        
        <tr>
            <td class="droite">
            <label>
          Password :
            </td>
          <td><input class="log" type="password" name="password" />
            </label></td>
        </tr>
        <tr>
          <td></td><td><input class="log" type="submit" value="OK"/>
          <button>
            <a class="btn" href="register.jsp">REGISTER</a>
            </button></td>
        </tr>
      </form>
    </table>
    </div>
    <div class="main"> <span>You are not log in the application. Please log in or register to enjoy this app.</span>
      <div class="stats">
        <div> <span> Number of register users </span> <span>
          <%@ page import="com.supinfo.suptravel.dao.UserDAO"%>
          <% 	UserDAO u = new UserDAO();
							Long nu = u.getNumberUser();
							out.println (nu); %>
          </span> </div>
        <div> <span>Number of trips available</span> <span>
          <%@ page import="com.supinfo.suptravel.dao.TripDAO"%>
          <% 	TripDAO t = new TripDAO();
						Long tu = t.getNumberTrip();
						out.println (tu); %>
          </span> </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

