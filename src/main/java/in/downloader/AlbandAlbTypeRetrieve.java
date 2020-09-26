package in.downloader;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dao.AlbAndAlbTypeDAOImpl;


public class AlbandAlbTypeRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlbAndAlbTypeDAOImpl albAndAlbTypeDAOImpl = null;
		ServletOutputStream outputStream = null;
		String album_type_id = req.getParameter("album_name");
		albAndAlbTypeDAOImpl = new AlbAndAlbTypeDAOImpl();
		byte[] album_image =  albAndAlbTypeDAOImpl.getAlbums(album_type_id);
		outputStream = resp.getOutputStream();
		outputStream.write(album_image);
		outputStream.close();
		
	}

}
