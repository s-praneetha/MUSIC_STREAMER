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



public class forgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO=null;
       
   
    public forgotPasswordController() {
        super();
        userDAO=new UserDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
            
		HttpSession session = request.getSession();
		String authcode=(String)session.getAttribute("authcode");
		String code = request.getParameter("authcode");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(code.equals(authcode)){
			
//			System.out.println(email+password);
			if(userDAO.update(email,password)) {
				request.setAttribute("message", "Password Updated Successfully!!");
				RequestDispatcher dispatcher =  request.getRequestDispatcher("/login.jsp");
				  dispatcher.forward(request, response);
			}
			
		}
		else {
			out.println("Incorrect verification");
			
			
		}
	}
	}

}
