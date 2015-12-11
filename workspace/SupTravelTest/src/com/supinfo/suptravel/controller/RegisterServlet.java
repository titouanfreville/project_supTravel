package com.supinfo.suptravel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.suptravel.dao.UserDAO;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("studentid"));
        String camp = request.getParameter("campus");
 
        setSession(request.getSession(true));
        try {
            UserDAO userDAO = new UserDAO();
            int code = userDAO.addUser(name, lastname, password, email, id, camp);
            if (code==0) {
            	request.setAttribute("new_user",true);
            	request.setAttribute("id",id);
            	request.setAttribute("password",password);
            	getServletConfig().getServletContext().getRequestDispatcher("/Login").forward(request,response);
            }
            else {
            	request.setAttribute("id_exist",true);
            	getServletConfig().getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);
            }
        } catch (Exception e) {
 
            e.printStackTrace();
        }
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

}
