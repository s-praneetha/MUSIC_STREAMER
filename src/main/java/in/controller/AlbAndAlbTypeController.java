package in.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import in.dao.AlbAndAlbTypeDAO;
import in.dao.AlbAndAlbTypeDAOImpl;
import in.entity.AlbumAndAlbumType;
import in.entity.LangAndCategory;


public class AlbAndAlbTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	AlbAndAlbTypeDAO albAndAlbTypeDAOImpl=null;
	
	public static String join;
	public static String albTypeJoin;
    
    public AlbAndAlbTypeController() {
        super();
        albAndAlbTypeDAOImpl = new AlbAndAlbTypeDAOImpl();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String page = request.getParameter("action");
		
		if(page==null) {
			page="HOME";
		}
		switch (page) {
		
		case "HOME":
			homePage(request, response);
			break;
			
		case "BROWSE":
			browsePage(request, response);
			break;
			
		default:
			homePage(request, response);
			break;
		}
	}
	
	private void browsePage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		List<AlbumAndAlbumType> allAlbumsList = albAndAlbTypeDAOImpl.getAllAlbums();
		request.setAttribute("allAlbumsList", allAlbumsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Browse.jsp");
		dispatcher.forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		String email = (String) session.getAttribute("email");
		String[] albtypes = request.getParameterValues("albtype");
		List<String> albtype = Arrays.asList(albtypes);
		albTypeJoin = "'" + StringUtils.join(albtype,"','") + "'";
		
		
		String[] langs = request.getParameterValues("lang");
		List<String> lang = Arrays.asList(langs);
		join = "'" + StringUtils.join(lang,"','") + "'";

		
		if(albAndAlbTypeDAOImpl.SaveLangCateInfo((String)session.getAttribute("email"),lang,albtype)) {
			System.out.println("Inserted success");
		}
		
		
		doGet(request, response);
	}
	
	private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		List<AlbumAndAlbumType> home = albAndAlbTypeDAOImpl.getData(join);
		
		request.setAttribute("home",home);
		
		String langs=albAndAlbTypeDAOImpl.getChoosenLangs((String)session.getAttribute("email"));
		String types=albAndAlbTypeDAOImpl.getChoosenTypes((String)session.getAttribute("email"));
//		System.out.println("LoginHome"+langs);
//		System.out.println("LoginHome"+types);
		
		Multimap<String, AlbumAndAlbumType> allalbums= albAndAlbTypeDAOImpl.getselected(langs,types);
		
		

		Multimap<String, AlbumAndAlbumType> topalbums=ArrayListMultimap.create();
		Set<String> keys = allalbums.keySet();
		for(String key:keys) {
			//System.out.println(key);

			if(key.equalsIgnoreCase("TOP PICKS")) {
				
				Collection<AlbumAndAlbumType> values=allalbums.get(key);
				for(AlbumAndAlbumType value:values){
					topalbums.put(value.getType_name(), value);
				}
			}
			
			
		}
		request.setAttribute("topalbums",topalbums);
		//System.out.println(topalbums);
		request.setAttribute("allalbums",allalbums);
		
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/Home.jsp");
		dispatcher.forward(request, response);
		
		
	}
	


}
