package in.downloader;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.dao.TrackDisplayDAOImpl;


public class TrackRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrackDisplayDAOImpl trackDisplayDAOImpl = null;
		ServletOutputStream outputStream = null;
		String track_no = req.getParameter("track_no");
		
		trackDisplayDAOImpl = new TrackDisplayDAOImpl();
		byte[] track_file =  trackDisplayDAOImpl.getTracks(track_no);
		outputStream = resp.getOutputStream();
		outputStream.write(track_file);
		outputStream.close();
		
	}

}
