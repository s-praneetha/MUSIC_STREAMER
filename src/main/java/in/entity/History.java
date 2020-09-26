package in.entity;

public class History {
	  private int trackid;
	  private String track_name;
	  private String track_duration;
	  private String performer_name;
	public int getTrackid() {
		return trackid;
	}
	public void setTrackid(int trackid) {
		this.trackid = trackid;
	}
	public String getTrack_name() {
		return track_name;
	}
	public void setTrack_name(String track_name) {
		this.track_name = track_name;
	}
	public String getTrack_duration() {
		return track_duration;
	}
	public void setTrack_duration(String track_duration) {
		this.track_duration = track_duration;
	}
	public String getPerformer_name() {
		return performer_name;
	}
	public void setPerformer_name(String performer_name) {
		this.performer_name = performer_name;
	}
	@Override
	public String toString() {
		return "History [trackid=" + trackid + ", track_name=" + track_name + ", track_duration=" + track_duration
				+ ", performer_name=" + performer_name + "]";
	}

  
  
	
  
}
