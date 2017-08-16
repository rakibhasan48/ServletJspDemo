package com;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.UserDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao ud;
	
	@Resource(name="jdbc/usersprac")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try{
			ud = new UserDao(dataSource);
		} catch(Exception e){
			throw new ServletException(e);
		}
	}	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		if(ud.validateUser(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", uname);
			session.setMaxInactiveInterval(5*60*60);
			String[] fname = uname.trim().split("\\s+");
			Cookie userName = new Cookie("user", fname[0]);
			userName.setMaxAge(5*60*60);
			response.addCookie(userName);
			if(uname.equals("admin")){
				RequestDispatcher rd = request.getRequestDispatcher("listUsers");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("name", uname);
			RequestDispatcher rd = request.getRequestDispatcher("UpPassFail.jsp");
			rd.forward(request, response);
		}
		
	}

}
