package in.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import in.dao.TrackDisplayDAOImpl;


public class DoGetErrorRecover extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	TrackDisplayDAOImpl trackDisplayDAOImpl = null;
	
    public DoGetErrorRecover() {
    	super();
    	trackDisplayDAOImpl = new TrackDisplayDAOImpl();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		int trackid=Integer.parseInt(request.getParameter("trnum"));		
		if(trackDisplayDAOImpl.saveHistory(email, trackid)) {
//			System.out.println("Done");
		}
		
	}

}
