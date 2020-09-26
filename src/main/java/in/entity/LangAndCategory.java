package in.entity;

public class LangAndCategory {
	private String email;
	private String langs;
	private String types;
	private int trackid;
	private int albumid;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLangs() {
		return langs;
	}
	public void setLangs(String langs) {
		this.langs = langs;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public int getTrackid() {
		return trackid;
	}
	public void setTrackid(int trackid) {
		this.trackid = trackid;
	}
	public int getAlbumid() {
		return albumid;
	}
	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}
	
	@Override
	public String toString() {
		return "LangAndCategory [email=" + email + ", langs=" + langs + ", types=" + types + ", trackid=" + trackid
				+ ", albumid=" + albumid + "]";
	}
	
	
	
}
