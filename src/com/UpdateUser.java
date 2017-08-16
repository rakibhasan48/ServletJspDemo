package com;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.UserBean;
import dao.UserDao;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
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
		try {
			
			String upName = request.getParameter("upName");
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
			ud.updateUser(ubean, upName);
			
			request.setAttribute("name", uname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserUp.jsp");
		dispatcher.forward(request, response);
	}
}
