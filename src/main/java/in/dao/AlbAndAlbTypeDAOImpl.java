package in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import in.entity.AlbumAndAlbumType;
import in.entity.AlbumType;
import in.util.DBConnectionUtil;

public class AlbAndAlbTypeDAOImpl implements AlbAndAlbTypeDAO {
	
	public static String GET_DATA;
	public static String GET_ALBUM_QUERY;
	public static String GET_ALBUM_IMAGE_QUERY = "SELECT album_image from tbl_addalbum where album_name=?";
	public static String GET_ALL_ALBUM= "SELECT * from tbl_addalbum";
	private final String GET_LANG = "SELECT DISTINCT language FROM tbl_addalbum as alb,tbl_addalbumtype as albtype where  alb.album_type_id= albtype.type_id";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement statement = null;
	
	@Override
	public List<AlbumAndAlbumType> getData(String langs) {
		
		GET_DATA="Select * from  tbl_addalbum where language in ("+langs+")";
		GET_ALBUM_QUERY="select album_image from  tbl_addalbum where language in ("+langs+") and album_name=?";
		AlbumAndAlbumType albumAndAlbumType = null;
		
		List<AlbumAndAlbumType> albumAndAlbumTypelist =  new ArrayList<AlbumAndAlbumType>();
		try {
			con = DBConnectionUtil.openConnection();
			ps = con.prepareStatement(GET_DATA);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				albumAndAlbumType = new AlbumAndAlbumType();
				albumAndAlbumType.setAlbum_id(rs.getString(1));
				albumAndAlbumType.setAlbum_name(rs.getString(2));
				albumAndAlbumType.setAlbum_type_id(rs.getString(3));	
				albumAndAlbumType.setAlbum_description(rs.getString(5));
				albumAndAlbumType.setLanguage(rs.getString(6));
				albumAndAlbumTypelist.add(albumAndAlbumType);
			}
		} catch (Exception e) {
			
		}
		return albumAndAlbumTypelist;
		
	}

	@Override
	public byte[] getAlbums(String album_name) {
		
		byte[] album_image = null;
		try {
			con = DBConnectionUtil.openConnection();
			ps = con.prepareStatement(GET_ALBUM_QUERY);
			ps.setString(1,album_name);
			rs = ps.executeQuery();
			if(rs.next()) {
				album_image = rs.getBytes(1);
			}
			
		} catch (Exception e) {
			
		}
		return album_image;
	}
	
	@Override
	public List<AlbumType> getAlbumTypes() {
		
		List<AlbumType> albumTypelist = null;
		AlbumType albumtype = null;
		try {
			albumTypelist = new ArrayList<AlbumType>();
			String sql = "SELECT * FROM tbl_addalbumtype";
			con = DBConnectionUtil.openConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				albumtype = new AlbumType();
				albumtype.setType_name(rs.getString("type_name"));
				albumTypelist.add(albumtype);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albumTypelist;
	}

	@Override
	public List<AlbumAndAlbumType> getLanguages() {
		
	
		AlbumAndAlbumType albumAndAlbumType = null;
		
		List<AlbumAndAlbumType> languagelist =  new ArrayList<AlbumAndAlbumType>();
		
		try {
			albumAndAlbumType = new AlbumAndAlbumType();
			con = DBConnectionUtil.openConnection();
			ps = con.prepareStatement(GET_LANG);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				albumAndAlbumType.setLanguage(rs.getString(1));
				languagelist.add(albumAndAlbumType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return languagelist;
			
	}

	@Override
	public Multimap<String, AlbumAndAlbumType> getselected(String langs,String types) {
		String sql1="Select * from  tbl_addalbum as alb,tbl_addalbumtype as albtype where alb.album_type_id= albtype.type_id and alb.language in ("+langs+") and albtype.type_name in ("+types+")";
		GET_ALBUM_QUERY="select alb.album_image from  tbl_addalbum as alb,tbl_addalbumtype as albtype where alb.album_type_id= albtype.type_id and alb.language in ("+langs+") and albtype.type_name in ("+types+") and album_name=?";
		AlbumAndAlbumType albumAndAlbumType = null;
    	Multimap<String, AlbumAndAlbumType> multiMap = ArrayListMultimap.create();
    	
    	try {
			con = DBConnectionUtil.openConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				albumAndAlbumType = new AlbumAndAlbumType();
				albumAndAlbumType.setAlbum_id(rs.getString(1));
				albumAndAlbumType.setAlbum_name(rs.getString(2));
				albumAndAlbumType.setAlbum_type_id(rs.getString(3));	
				albumAndAlbumType.setAlbum_description(rs.getString(5));
				albumAndAlbumType.setLanguage(rs.getString(6));
				albumAndAlbumType.setType_name(rs.getString(8));
				albumAndAlbumType.setType_description(rs.getString(9));
//				System.out.println(albumAndAlbumType.toString());
				
				multiMap.put(rs.getString(8),albumAndAlbumType);
				
			
			}
    		Set<String> keys = multiMap.keySet();
			
		} catch (Exception e) {
			
		}
    	return multiMap;
    	
	}

	@Override
	public boolean SaveLangCateInfo(String email,List<String> lang,List<String> type) {
		boolean flag = false;
		
		
		try {

			for(String l:lang) {
				
				String sql1="insert into langs values('"+email+"','"+l+"')";
				con = DBConnectionUtil.openConnection();
				ps = con.prepareStatement(sql1);
				ps.executeUpdate();
			}
			for(String t:type) {
				String sql2="insert into types values('"+email+"','"+t+"')";
				con = DBConnectionUtil.openConnection();
				ps = con.prepareStatement(sql2);
				ps.executeUpdate();
			}
			flag = true;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public String getChoosenLangs(String email) {
		List<String> langlist=new ArrayList<String>();
		String sql1="SELECT * FROM langs where email='"+email+"'";
		String lang;
		try {
			con = DBConnectionUtil.openConnection();
			statement=con.createStatement();
			
			rs = statement.executeQuery(sql1);
			
			while(rs.next()) {
				langlist.add(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		lang="'" + StringUtils.join(langlist,"','") + "'";
		return lang;
	}

	@Override
	public String getChoosenTypes(String email) {
		List<String> typeslist=new ArrayList<String>();
		String sql1="SELECT * FROM types where email='"+email+"'";
		String types;
		try {
			con = DBConnectionUtil.openConnection();
			statement=con.createStatement();
			
			rs = statement.executeQuery(sql1);
			
			while(rs.next()) {
				typeslist.add(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		types="'" + StringUtils.join(typeslist,"','") + "'";
		return types;
	}

	@Override
	public List<AlbumAndAlbumType> getAllAlbums() {
		
	
		AlbumAndAlbumType albumAndAlbumType = null;
		
		List<AlbumAndAlbumType> albumList =  new ArrayList<AlbumAndAlbumType>();
		try {
			con = DBConnectionUtil.openConnection();
			ps = con.prepareStatement(GET_ALL_ALBUM);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				albumAndAlbumType = new AlbumAndAlbumType();
				albumAndAlbumType.setAlbum_id(rs.getString(1));
				albumAndAlbumType.setAlbum_name(rs.getString(2));
				albumAndAlbumType.setAlbum_type_id(rs.getString(3));	
				albumAndAlbumType.setAlbum_description(rs.getString(5));
				albumAndAlbumType.setLanguage(rs.getString(6));
				albumList.add(albumAndAlbumType);
			}
		} catch (Exception e) {
			
		}
		return albumList;
	}


	@Override
	public byte[] getAllAlbumImages(String album_name) {
		
		byte[] album_image = null;
		try {
			String GET_ALBUM_IMAGE_QUERY = "SELECT album_image from tbl_addalbum where album_name=?";
			con = DBConnectionUtil.openConnection(); 
			ps = con.prepareStatement(GET_ALBUM_IMAGE_QUERY);		
			ps.setString(1,album_name);
			rs = ps.executeQuery();
			if(rs.next()) {
				album_image = rs.getBytes(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album_image;
	}

	@Override
	public List<AlbumAndAlbumType> getEachType(String type) {
		
		AlbumAndAlbumType albumAndAlbumType = null;
		List<AlbumAndAlbumType> typealbumList =  new ArrayList<AlbumAndAlbumType>();
		try {
			String sql = "SELECT * FROM tbl_addalbumtype albtype,tbl_addalbum alb where albtype.type_id = alb.album_type_id and type_name='"+type+"'";
			con = DBConnectionUtil.openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				albumAndAlbumType = new AlbumAndAlbumType();
				albumAndAlbumType.setAlbum_id(rs.getString(5));
				albumAndAlbumType.setAlbum_name(rs.getString(6));
				albumAndAlbumType.setAlbum_type_id(rs.getString(7));	
				albumAndAlbumType.setAlbum_description(rs.getString(9));
				albumAndAlbumType.setLanguage(rs.getString(10));
				albumAndAlbumType.setType_name(rs.getString(2));
				albumAndAlbumType.setType_description(rs.getString(3));
				typealbumList.add(albumAndAlbumType);
			}
		} catch (Exception e) {
			
		}
		return typealbumList;
	}

	@Override
	public byte[] getEachTypeImage(String album_name) {
		byte[] album_image = null;
		try {
			String sql = "SELECT album_image FROM tbl_addalbumtype albtype,tbl_addalbum alb where albtype.type_id = alb.album_type_id and album_name=?";
			con = DBConnectionUtil.openConnection(); 
			ps = con.prepareStatement(sql);		
			ps.setString(1,album_name);
			rs = ps.executeQuery();
			if(rs.next()) {
				album_image = rs.getBytes(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album_image;
	}

	@Override
	public byte[] getEachTypeImg(String type_name) {
		byte[] type_image = null;
		try {
			String sql = "SELECT type_image FROM tbl_addalbumtype albtype,tbl_addalbum alb where albtype.type_id = alb.album_type_id and type_name=?";
			con = DBConnectionUtil.openConnection(); 
			ps = con.prepareStatement(sql);		
			ps.setString(1,type_name);
			rs = ps.executeQuery();
			if(rs.next()) {
				type_image = rs.getBytes(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type_image;
	}

	

}
