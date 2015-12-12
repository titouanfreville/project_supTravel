package com.supinfo.suptravel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suptravel.bean.User;
import com.supinfo.suptravel.cart.TripCart;
import com.supinfo.suptravel.dao.UserDAO;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());doGet(request, response);
		
	} 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sto = request.getParameter("id");
		int sid;
		if (sto == null) {
			sid = (Integer) request.getAttribute("id");
		} else {
			sid = Integer.parseInt(sto);
		}
		
        String pass = request.getParameter("password");
        if (pass == null) {
        	pass = (String) request.getAttribute("password");
        }
        Boolean new_user = (Boolean) request.getAttribute("new_user");
        UserDAO userDAO = new UserDAO();
        User ref = userDAO.logIn(sid,pass);
        session=request.getSession();
        if (ref != null) {
	        int user_id = ref.getId();
        	TripCart tc = new TripCart();
            System.out.println("TC in Login"+tc);
	        System.out.println(session);
	        session.setAttribute("new_user", new_user);
        	session.setAttribute("user_id", user_id);
        	session.setAttribute("campus_id", sid);
        	session.setAttribute("name", ref.getName());
        	session.setAttribute("lastname", ref.getLastname());
        	session.setAttribute("cart", tc);
        	response.sendRedirect("connected/index.jsp");
        } else {
        	session.setAttribute("user_id", null);
        }
	}

}