package com.supinfo.suptravel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.suptravel.bean.User;
import com.supinfo.suptravel.dao.UserDAO;

/**
 * Servlet implementation class BeforeEditServlet
 */
@WebServlet("/connected/BeforeEdit")
public class BeforeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeforeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());doGet(request, response);
		UserDAO udao = new UserDAO();
        Cookie[] cookie = request.getCookies();System.out.println("------------------------------------------\n"+cookie+"-----------------------------------------------------------\n");
        for (Cookie c : cookie) {System.out.println(c);
        	if (c.getName() != null && c.getName().equals("user_id")) {
        		int id = Integer.parseInt(c.getValue());
        		System.out.println(id);
        		User u = udao.getUserObject(id);
        		System.out.println("Shrauihruaize\n"+u+"\nazeuinhazeuiohazo\n");
        		ServletContext sc = getServletContext();
        	    RequestDispatcher rd = sc.getRequestDispatcher("/connected/edit.jsp");
        		request.setAttribute("userinfo",u);
    			getServletConfig().getServletContext().getRequestDispatcher("/connected/edit.jsp").forward(request,response);
//        	    rd.forward(request, response);
        	} 
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);UserDAO udao = new UserDAO();
        Cookie[] cookie = request.getCookies();System.out.println("------------------------------------------\n"+cookie+"-----------------------------------------------------------\n");
        for (Cookie c : cookie) {System.out.println(c);
        	if (c.getName() != null && c.getName().equals("user_id")) {
        		int id = Integer.parseInt(c.getValue());
        		System.out.println(id);
        		User u = udao.getUserObject(id);
        		System.out.println("Shrauihruaize\n"+u+"\nazeuinhazeuiohazo\n");
        		ServletContext sc = getServletContext();
        	    RequestDispatcher rd = sc.getRequestDispatcher("/connected/edit.jsp");
        		request.setAttribute("userinfo",u);
    			getServletConfig().getServletContext().getRequestDispatcher("/connected/edit.jsp").forward(request,response);
//        	    rd.forward(request, response);
        	} 
        }
	}

}
