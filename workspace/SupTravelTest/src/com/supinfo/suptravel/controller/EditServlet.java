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
import com.supinfo.suptravel.dao.TripbagDAO;
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
		doGet(request, response);
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String camp = request.getParameter("campus");
		UserDAO udao = new UserDAO();
        Cookie[] cookie = request.getCookies();
        User nu = new User();
        nu.setCampus(camp);
        nu.setStudentid(10);
        nu.setEmail(email);
        nu.setPassword(password);
        nu.setLastname(lastname);
        nu.setName(name);
        System.out.println("------------------------------------------\n"+cookie+"-----------------------------------------------------------\n");
        for (Cookie c : cookie) {System.out.println(c);
        	if (c.getName() != null && c.getName().equals("user_id")) {
        		int id = Integer.parseInt(c.getValue());
        		User u = udao.getUserObject(id);
        		
        		System.out.println("Shrauihruaize\n"+u+"\nazeuinhazeuiohazo\n");
        		udao.Update(u,nu);
                response.sendRedirect("edit.jsp");	
        	} 
        }
	}

}
