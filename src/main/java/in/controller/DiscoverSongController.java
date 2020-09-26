package in.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dao.AlbAndAlbTypeDAO;
import in.dao.AlbAndAlbTypeDAOImpl;
import in.entity.AlbumAndAlbumType;


public class DiscoverSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AlbAndAlbTypeDAO albAndAlbTypeDAOImpl=null;
	
    public DiscoverSongController() {
        super();
        albAndAlbTypeDAOImpl = new AlbAndAlbTypeDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String type = request.getParameter("type");
		String page = request.getParameter("action");
		if(page==null) {
			page="DISCOVER";
		}
		switch (page) {
		
		case "DISCOVER":
			discoverType(request, response);
			break;
			
			
		default:
			discoverType(request, response);
			break;
		}
		
	}

	
	private void discoverType(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		String type = request.getParameter("type");
		List<AlbumAndAlbumType> discoveralbums = albAndAlbTypeDAOImpl.getEachType(type);
		
		request.setAttribute("discoveralbums", discoveralbums);
		//System.out.println(discoveralbums.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DiscoverTypes.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
