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
 * Servlet implementation class PassUpServlet
 */
@WebServlet("/PassUpServlet")
public class PassUpServlet extends HttpServlet {
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
		
			String oldPass = request.getParameter("oldPass");
			String newPass = request.getParameter("newPass");
			String name = request.getParameter("name");
			
			UserBean ubean = new UserBean();
			ubean.setUname(name);
			ubean.setPass(newPass);

			boolean val = ud.updatePass(ubean, oldPass);
			
			request.setAttribute("name", name);
			
			if(val){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UpPassSuccess.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/UpPassFail.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
