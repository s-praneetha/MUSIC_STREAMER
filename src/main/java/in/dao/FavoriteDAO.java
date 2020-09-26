package in.dao;

import java.util.List;

import in.entity.AddAlbum;

public interface FavoriteDAO {
	
	List<AddAlbum> getFavorites(String email);
	
	byte[] getFavImage(String album_name);
}
