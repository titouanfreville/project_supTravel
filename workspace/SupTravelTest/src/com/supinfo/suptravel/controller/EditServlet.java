package com.supinfo.suptravel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.suptravel.bean.User;
import com.supinfo.suptravel.dao.UserDAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/connected/Edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		Cookie[] cookie = request.getCookies();
		UserDAO udao= new UserDAO();
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("studentid"));
        String camp = request.getParameter("campus");
		for (Cookie c : cookie) {
			System.out.println(c);
	       	if (c.getName() != null && c.getName().equals("user_id")) {
	       		int id = Integer.parseInt(c.getValue());
        		User u = udao.getUserObject(id);
        		u.setCampus(campus);
	       	} 
       }
       try {
           
       } catch (Exception e) {

           e.printStackTrace();
       }
	}
}
