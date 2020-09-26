package in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import in.entity.SendEmail;
import in.entity.User;


public class SendMailFPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    protected void  processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
		
    	response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
		//String username = 	request.getParameter("username");
		String email = 	request.getParameter("email");
		//String password = request.getParameter("password");
		SendEmail sm = new SendEmail();
		String code = sm.getRandom();
		
		session.setAttribute("authcode", code);
		User user = new User(email,code);
		boolean test = sm.sendEmail(user);
		if(test) {		
			session.setAttribute("email", email);
			//session.setAttribute("username", username);
			//session.setAttribute("password", password);
		  RequestDispatcher dispatcher =  request.getRequestDispatcher("/forgotpassword.jsp");
		  dispatcher.forward(request, response);
		}
		else{
    		  out.println("Failed to send verification email");
    	   }
        }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 processRequest(request, response);
	}

}
