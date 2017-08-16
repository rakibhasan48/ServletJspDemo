package com;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String name = request.getParameter("name");
			ud.deleteUser(name);
			
			request.setAttribute("name", name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserDel.jsp");
		dispatcher.forward(request, response);
	}

}
