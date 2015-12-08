package com.supinfo.suptravel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.suptravel.bean.Trip;
import com.supinfo.suptravel.bean.User;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// TODO Auto-generated method stub
				String triptobook = request.getParameter("trip");
				System.out.println("Submit :"+triptobook);
//		        setSession(request.getSession(true));
		        UserDAO udao = new UserDAO();
		        TripDAO tdao = new TripDAO();
		        cookie = request.getCookies();
		        System.out.println("------------------------------------------\n"+cookie+"-----------------------------------------------------------\n");
		        for (Cookie c : cookie) {
		        	System.out.println(c);
		        	if (c.getName() != null && c.getName().equals("user_id")) {
		        		System.out.println("--------------------------------------------\n"+c.getName().equals("user_id")+"------------------------------------\n");
		        		int id = Integer.parseInt(c.getValue());
		        		User u = udao.getUserObject(id);
		        		Trip t = tdao.getTripObject(triptobook);
		        		TripbagDAO bag = new TripbagDAO();
		        		bag.bookTrip(t, u);
		        	} 
		        	if (c.getName() == null) {
<<<<<<< HEAD
		        		response.sendRedirect("/index.jsp");
=======
		        		response.sendRedirect("index.jsp");
>>>>>>> master
		        	} 
		        }
		        try {
		            
		        } catch (Exception e) {
		 
		            e.printStackTrace();
		        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			cookie = request.getCookies();
			System.out.println("doPost -------------------------------\n"+cookie+"-----------------------------------------------------------\n");
	        for (Cookie c : cookie) {
	        	System.out.println(c);
	        	       	
	        }
	}

}
