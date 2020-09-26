package in.dao;

import java.util.List;

import com.google.common.collect.Multimap;

import in.entity.AlbumAndAlbumType;
import in.entity.AlbumType;
import in.entity.LangAndCategory;


public interface AlbAndAlbTypeDAO {
	
	//for discover
	List<AlbumAndAlbumType> getEachType(String type);
	
	byte[] getEachTypeImage(String album_name);
	
	byte[] getEachTypeImg(String type_name); //for top display
	//for discover end
	
	List<AlbumAndAlbumType> getAllAlbums();
	
	byte[] getAllAlbumImages(String album_name);
	
	List<AlbumAndAlbumType> getData(String langs);
	
	byte[] getAlbums(String album_name);
	
	List<AlbumType> getAlbumTypes();
	
	List<AlbumAndAlbumType> getLanguages();
	
	Multimap<String, AlbumAndAlbumType> getselected(String langs,String types);
	
	boolean SaveLangCateInfo(String email,List<String> lang,List<String> type);
	
	String getChoosenLangs(String email);
	String getChoosenTypes(String email);
	
	
}
