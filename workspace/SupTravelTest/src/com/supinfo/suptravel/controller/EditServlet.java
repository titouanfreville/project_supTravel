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

import com.supinfo.suptravel.bean.User;
import com.supinfo.suptravel.dao.TripbagDAO;
import com.supinfo.suptravel.dao.UserDAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/connected/Edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    session = request.getSession();
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String camp = request.getParameter("campus");
		UserDAO udao = new UserDAO();
        User nu = new User();
        nu.setCampus(camp);
        nu.setStudentid(10);
        nu.setEmail(email);
        nu.setPassword(password);
        nu.setLastname(lastname);
        nu.setName(name);
		int id = (int)session.getAttribute("user_id");
		User u = udao.getUserObject(id);
		udao.Update(u,nu);
		request.setAttribute("modify",true);
    	getServletConfig().getServletContext().getRequestDispatcher("/connected/edit.jsp").forward(request,response);

	}

}
