package com.supinfo.suptravel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.suptravel.dao.TripbagDAO;

/**
 * Servlet implementation class TripsbyUserServlet
 */
@WebServlet("/TripsbyUser")
public class TripsbyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cookie[] cookie;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripsbyUserServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        TripbagDAO tbdao = new TripbagDAO();
        cookie = request.getCookies();System.out.println("------------------------------------------\n"+cookie+"-----------------------------------------------------------\n");
        for (Cookie c : cookie) {System.out.println(c);
        	if (c.getName() != null && c.getName().equals("user_id")) {
        		int id = Integer.parseInt(c.getValue());
        		System.out.println(id);
        		ArrayList<String> res = tbdao.tripByUser(id);
        		System.out.println("Shrauihruaize\n"+res+"\nazeuinhazeuiohazo\n");
        		request.setAttribute("ltrip",res);
    			getServletConfig().getServletContext().getRequestDispatcher("/mytrips.jsp").forward(request,response);
        	} 
        }
        try {
            
        } catch (Exception e) {
 
            e.printStackTrace();
        }
	}

}
