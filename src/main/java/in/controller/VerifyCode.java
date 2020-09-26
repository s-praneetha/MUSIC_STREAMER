package in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dao.UserDAO;
import in.dao.UserDAOImpl;
import in.entity.User;


public class VerifyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO=null;
       
   
    public VerifyCode() {
        super();
        userDAO=new UserDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
            
		HttpSession session = request.getSession();
		String authcode=(String)session.getAttribute("authcode");
		String code = request.getParameter("authcode");
		if(code.equals(authcode)){
			
			String username = (String)session.getAttribute("username");
			String email = 	(String)session.getAttribute("email");
			String password = 	(String)session.getAttribute("password");
			User u = new User();
			u.setUsername(username);
			u.setEmail(email);
			u.setPassword(password);
			if(userDAO.save(u)) {
				request.setAttribute("message", "Saved Successfully!!");
				RequestDispatcher dispatcher =  request.getRequestDispatcher("/ChooseLanguages.jsp");
				  dispatcher.forward(request, response);
			}
			
		}
		else {
			out.println("Incorrect verification");
			
		}
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
