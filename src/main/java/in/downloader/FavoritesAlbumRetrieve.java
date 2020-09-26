package in.downloader;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.dao.FavoriteDAOImpl;


public class FavoritesAlbumRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FavoriteDAOImpl favoriteDAOImpl = null;
		ServletOutputStream outputStream = null;
		String album_type_id = req.getParameter("album_name");
		favoriteDAOImpl = new FavoriteDAOImpl();
		byte[] album_image =  favoriteDAOImpl.getFavImage(album_type_id);
		outputStream = resp.getOutputStream();
		outputStream.write(album_image);
		outputStream.close();
	}	
	
}
