package com.supinfo.suptravel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suptravel.bean.Trip;
import com.supinfo.suptravel.cart.Item;
import com.supinfo.suptravel.cart.TripCart;
import com.supinfo.suptravel.dao.TripDAO;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/connected/AddtoCart")
public class AddtoCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
	    response.sendRedirect("restanes.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        
        String name = req.getParameter("trips");
        System.out.println("Name in ADD TO CHART"+name);
        int quant = Integer.parseInt(req.getParameter("quant"));
        System.out.println("Qaunt in ADD TO CHART"+quant);
        TripDAO tdao = new TripDAO();
        TripCart tc = (TripCart) session.getAttribute("cart");
        if (tc == null) {
        	tc = new TripCart();
        	session.setAttribute("cart", tc);
        }
        System.out.println("TC in ADD TO CHART"+tc);
        Trip t = tdao.getTripObject(name);
        System.out.println("T in ADD TO CHART"+t);
        Item it = new Item();
        
        it.setTrip(t);
        it.setQuantity(quant);
        System.out.println("IT in ADD TO CHART"+it);
        tc.addItem(it);
        

	    res.sendRedirect("cart.jsp");
	}

}
