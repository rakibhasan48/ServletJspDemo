package com;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.UserBean;
import config.MyConnection;
import dao.UserDao;

/**
 * Servlet implementation class FirstServlet
 */

public class FirstServlet extends HttpServlet {
//    private MyConnection con;  
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
		try {
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String langs[] = request.getParameterValues("lang");
			String quali = request.getParameter("quali");
			
			String lang = "";
			for(String temp : langs){
				lang += temp + ", ";
			}
			
			UserBean ubean = new UserBean();
			ubean.setUname(uname);
			ubean.setPass(pass);
			ubean.setQuali(quali);
			ubean.setLang(lang);
			
			int i = ud.createUser(ubean);
			
			
			request.setAttribute("uname", uname);
			request.setAttribute("pass", pass);
			
			if(i>0){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Welcome.jsp");
				
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Fail.jsp");
				
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Fail.jsp");
			
			dispatcher.forward(request, response);
		}
	
		
	}

}
