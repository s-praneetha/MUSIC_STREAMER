package in.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dao.TrackDisplayDAO;
import in.dao.TrackDisplayDAOImpl;
import in.entity.History;


public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	TrackDisplayDAO historyDAO = null;
	
    public HistoryController() {
        super();
        historyDAO = new TrackDisplayDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action= request.getParameter("action");
		if(action == null) {
			action = "DISPLAY";
		}
			switch (action) {
			case "DISPLAY":
				displayHistory(request,response);
				break;
			default:
				displayHistory(request,response);
				break;
			}
		
		
	}

	private void displayHistory(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<History> histories = historyDAO.getHistory(email);
		request.setAttribute("histories", histories);
		//System.out.println(histories.toString());
		RequestDispatcher dispacher = request.getRequestDispatcher("/History.jsp");
		dispacher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
