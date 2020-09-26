package in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.entity.AddAlbum;
import in.util.DBConnectionUtil;

public class FavoriteDAOImpl implements FavoriteDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement statement = null;
	public static String GET_FAV_IMAGE;
	
	@Override
	public List<AddAlbum> getFavorites(String email) {
		LogAndAuditDAO logAndAuditDAO = null;
		logAndAuditDAO = new LogAndAuditDAOImpl();
		if(logAndAuditDAO.save("Favorites Retrieve", "User", String.valueOf(email))) {
			System.out.println("Favorites Retrieval event inserted");
		}
		AddAlbum addfavorites = null;
		List<AddAlbum> favoritelist = new ArrayList<AddAlbum>();
		String sql = "Select * from favorite f,tbl_addalbum album where f.albumid=album.album_id and email='"+email+"'";
		GET_FAV_IMAGE = "Select album.album_image from favorite f,tbl_addalbum album where f.albumid=album.album_id and email='"+email+"' and album.album_name=?";
		try {
			con = DBConnectionUtil.openConnection();
			statement =con.createStatement();
			rs = statement.executeQuery(sql);
			
			
			while(rs.next()) {				
				addfavorites = new AddAlbum();
				addfavorites.setAlbum_id(rs.getString(3));
				addfavorites.setAlbum_type_id(rs.getString(5));
				addfavorites.setAlbum_name(rs.getString(4));
				addfavorites.setAlbum_description(rs.getString(7));
				addfavorites.setLanguage(rs.getString(8));
				favoritelist.add(addfavorites);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return favoritelist;
	}

	@Override
	public byte[] getFavImage(String album_name) {
		byte[] album_image = null;
		

		try {
			con = DBConnectionUtil.openConnection();
			ps = con.prepareStatement(GET_FAV_IMAGE);
			ps.setString(1,album_name);
			rs = ps.executeQuery();
			if(rs.next()) {
				album_image = rs.getBytes(1);
			}
			
		} catch (Exception e) {
			
		}
		return album_image;
	}

}
