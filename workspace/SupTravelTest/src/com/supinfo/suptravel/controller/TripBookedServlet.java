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

import com.supinfo.suptravel.dao.TripbagDAO;

/**
 * Servlet implementation class TripsbyUserServlet
 */
@WebServlet("/connected/TripsBooked")
public class TripBookedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cookie[] cookie;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripBookedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        
        TripbagDAO tbdao = new TripbagDAO();
        int id = (int) session.getAttribute("user_id");
		System.out.println(id);
		ArrayList<Object[]> lres = tbdao.tripByUser(id);
			
		request.setAttribute("ltrip",lres);
		getServletConfig().getServletContext().getRequestDispatcher("/connected/mytrips.jsp").forward(req,res);
        	
	}

}
