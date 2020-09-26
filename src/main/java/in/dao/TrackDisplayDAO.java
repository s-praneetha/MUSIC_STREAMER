package in.dao;

import java.util.List;

import in.entity.AddTrack;
import in.entity.AlbumAndAlbumType;
import in.entity.History;

public interface TrackDisplayDAO {

	boolean saveHistory(String email,int trackid);
	
	//boolean delete(String email,int id);
	
	List<History> getHistory(String email);
	//List<AddTrack> getAlbumtracks();
	byte[] getTracks(String id);
	
	List<AddTrack> getAlbumtracks(int id);
	
	AlbumAndAlbumType getTrackAlbum(int id);
	
	byte[] getTrackalbumimage(String id);
	
	boolean SaveFavorite(String email,int albumid);
	
	List<Integer> getFavs(String email);
}
