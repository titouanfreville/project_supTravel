package com.supinfo.suptravel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        int id = (int) userDAO.logIn(name,password);
        System.out.println(id);
        session=request.getSession();
        System.out.println(session);
        if (!(id < 0)) {
        	Cookie sid = new Cookie("user_id",Integer.toString(id));
        	session.setAttribute("user_id", id);
        	System.out.println(session.getAttribute("user_id"));
            response.addCookie(sid);
            response.sendRedirect("connected/index.jsp");
        } else {
        	session.setAttribute("user_id", null);
        	response.sendRedirect("index.jsp");
        }
	}

}