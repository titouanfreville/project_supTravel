package com.supinfo.suptravel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suptravel.cart.TripCart;
import com.supinfo.suptravel.dao.UserDAO;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();
        ArrayList<Integer> ref = userDAO.logIn(name,password);
        if (ref != null) {
	        int campus_id = (int) ref.get(1);
	        int user_id = (int) ref.get(0);
        	TripCart tc = new TripCart();
            System.out.println("TC in Login"+tc);
	        session=request.getSession();
	        System.out.println(session);
        	session.setAttribute("user_id", user_id);
        	session.setAttribute("campus_id", campus_id);
        	session.setAttribute("cart", tc);
        	System.out.println(session.getAttribute("user_id"));
            response.sendRedirect("connected/index.jsp");
        } else {
        	session.setAttribute("user_id", null);
        }
	}

}