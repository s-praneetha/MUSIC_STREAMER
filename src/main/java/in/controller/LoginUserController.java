package in.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dao.LoginDAO;
import in.dao.LoginDAOImpl;
import in.entity.User;

public class LoginUserController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	LoginDAO loginDAO = null;
	
	 public LoginUserController() {
		
		loginDAO = new LoginDAOImpl();
	
	 }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		HttpSession session=req.getSession();
		
		
		String status =  loginDAO.authenticate(user);
		
		if(status.equals("true")) {
			session.setAttribute("email",user.getEmail());
			session.setAttribute("username",user.getUsername());
			resp.sendRedirect("AlbAndAlbTypeController?action=HOME");
		}
		
		if(status.equals("false")) {
			resp.sendRedirect("login.jsp?status=false");
		}
		if(status.equals("error")) {
			resp.sendRedirect("login.jsp?status=error");
		}
		
	
	}

}
