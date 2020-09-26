package in.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dao.TrackDisplayDAOImpl;
import in.entity.AddTrack;
import in.entity.AlbumAndAlbumType;


public class TrackDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int  albumid;
	
	TrackDisplayDAOImpl trackDisplayDAOImpl = null;
	
    public TrackDisplayController() {
    	trackDisplayDAOImpl = new TrackDisplayDAOImpl();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("action");
		 albumid= Integer.parseInt(request.getParameter("id"));
		
		if(page==null) {
			page="trackDisplay";
		}
		switch (page) {
		
		case "trackDisplay":
			displayTrack(request, response);
			break;
			
		case "SaveFav":
			saveFav(request, response);
			break;
				
		default:
			displayTrack(request, response);
			break;
		}
	}

	
	private void displayTrack(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		List<AddTrack> tracklist  = trackDisplayDAOImpl.getAlbumtracks(albumid);
		AlbumAndAlbumType trackalbum=trackDisplayDAOImpl.getTrackAlbum(albumid);
		List<Integer>favslist=trackDisplayDAOImpl.getFavs(email);
		
		boolean added;
		if(favslist.contains(albumid)) {
			added=true;
			
		}else {
			added=false;
		}
		
		request.setAttribute("addedtofav",added);		
		request.setAttribute("albuminfo",trackalbum);
		request.setAttribute("tracklist", tracklist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeTrackDisplay.jsp");
		dispatcher.forward(request, response);
	}

	protected void saveFav(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		List<Integer>favslist=trackDisplayDAOImpl.getFavs(email);
		String url="TrackDisplayController?action=trackDisplay&id="+albumid;

		if(favslist.contains(albumid)) {
			
		}else {
			
			if(trackDisplayDAOImpl.SaveFavorite(email, albumid)) {
				System.out.println("Added to Favorites");
				
			}
		}
		response.sendRedirect(url);
	}
}
