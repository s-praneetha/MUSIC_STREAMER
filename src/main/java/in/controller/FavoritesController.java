package in.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.dao.FavoriteDAO;
import in.dao.FavoriteDAOImpl;
import in.entity.AddAlbum;


public class FavoritesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FavoriteDAO favoriteDAO=null;
  
    public FavoritesController() {
        super();
        favoriteDAO=new FavoriteDAOImpl();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		List<AddAlbum> favalbumsList=favoriteDAO.getFavorites(email);
		request.setAttribute("favoritealbums",favalbumsList);
		RequestDispatcher disp=request.getRequestDispatcher("/Favorites.jsp");
		disp.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
