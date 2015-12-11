package com.supinfo.suptravel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Vector;

import com.supinfo.suptravel.bean.Trip;
import com.supinfo.suptravel.bean.User;
import com.supinfo.suptravel.cart.*;
import com.supinfo.suptravel.dao.TripDAO;
import com.supinfo.suptravel.dao.TripbagDAO;
import com.supinfo.suptravel.dao.UserDAO;

/**
 * Servlet implementation class BookTripServlet
 */
@WebServlet("/connected/BookTrip")
public class BookTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cookie[] cookie;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        UserDAO udao = new UserDAO();
        TripCart tcart = (TripCart) session.getAttribute("cart");
        int id = (int) session.getAttribute("user_id");
		User u = udao.getUserObject(id);
		Vector<Item> vit = tcart.getItems();
		
		for (Item it : vit) {
			TripbagDAO bag = new TripbagDAO();
			bag.bookTrip(it.getTrip(), u, it.getQuantity() );			
		}
		tcart = new TripCart(); 
		session.setAttribute("booked", true);
		session.setAttribute("cart", tcart);
	    res.sendRedirect("index.jsp");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

}
