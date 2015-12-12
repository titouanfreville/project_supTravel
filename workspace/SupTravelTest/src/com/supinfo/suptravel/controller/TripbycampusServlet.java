package com.supinfo.suptravel.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suptravel.dao.TripDAO;
import com.supinfo.suptravel.dao.UserDAO;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/connected/Trip")
public class TripbycampusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String campus = request.getParameter("campus");
		TripDAO tdao = new TripDAO();
		try {
			ArrayList<String> ltrip = (ArrayList<String>) tdao.listTripsbyCampus(campus);
			request.setAttribute("ltrip",ltrip);
			getServletConfig().getServletContext().getRequestDispatcher("/connected/tripbycampus.jsp").forward(request,response);
		} catch (Exception e){
			throw e;			
		}
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

}