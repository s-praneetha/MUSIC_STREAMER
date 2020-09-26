package in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import in.entity.AddTrack;
import in.entity.AlbumAndAlbumType;
import in.entity.History;
import in.util.DBConnectionUtil;

public class TrackDisplayDAOImpl implements TrackDisplayDAO{

	private final String GET_QUERY= "SELECT trk.track_file from tbl_addtrack as trk,tbl_addperformer as performer where trk.track_performer = performer.performer_id and track_no=?";
	public static String sql2;
	public static String sql3;

	Connection con = null;
	PreparedStatement ps = null;
	java.sql.Statement statement=null;
	ResultSet rs = null;

	@Override
	public List<AddTrack> getAlbumtracks(int id) {
		AddTrack gettracks = null;
		List<AddTrack> albumtracklist =  new ArrayList<AddTrack>();
		try {
			String sql = "SELECT * from tbl_addtrack as trk,tbl_addperformer as performer where trk.track_performer = performer.performer_id and trk.track_album="+id;	
			con = DBConnectionUtil.openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				gettracks =new AddTrack();
				gettracks.setTrack_id(rs.getString(1));
				gettracks.setTrack_performer(rs.getString(10));
				gettracks.setTrack_album(rs.getString(3));
				gettracks.setTrack_no(rs.getString(4));
				gettracks.setTrack_name(rs.getString(5));
				gettracks.setTrack_duration(rs.getString(6));
				gettracks.setTrack_description(rs.getString(7));
				albumtracklist.add(gettracks);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return albumtracklist;	
	}

		@Override
		public byte[] getTracks(String id) {
			byte[] track_file = null;
			try {
				
				con = DBConnectionUtil.openConnection();
				ps = con.prepareStatement(GET_QUERY);
				ps.setString(1,id);
				rs = ps.executeQuery();
				if(rs.next()) {
					track_file = rs.getBytes(1);
				}
			} catch (Exception e) {
				
			}
			return track_file;
		}


		@Override
		public AlbumAndAlbumType getTrackAlbum(int id) {
			String sql="Select distinct(alb.album_id),alb.album_name,alb.album_description,alb.language from  tbl_addalbum as alb where  alb.album_id="+id;
			sql2= "select album_image from tbl_addalbum where album_id="+id+" and album_name=?";
			AlbumAndAlbumType trackalbum=null;
			
			try {
				con = DBConnectionUtil.openConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					trackalbum=new AlbumAndAlbumType();
					trackalbum.setAlbum_id(String.valueOf(rs.getInt(1)));
					trackalbum.setAlbum_name(rs.getString(2));
					trackalbum.setAlbum_description(rs.getString(3));
					trackalbum.setLanguage(rs.getString(4));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return trackalbum;
		}


		@Override
		public byte[] getTrackalbumimage(String id) {
		
			byte[] album_file = null;
			try {
			
				con = DBConnectionUtil.openConnection();
				ps = con.prepareStatement(sql2);
				ps.setString(1,id);
				rs = ps.executeQuery();
				if(rs.next()) {
					album_file = rs.getBytes(1);
				}
			} catch (Exception e) {
				
			}
			return album_file;
			
		}
		

		@Override
		public boolean SaveFavorite(String email, int albumid) {
			LogAndAuditDAO logAndAuditDAO = null;
			logAndAuditDAO = new LogAndAuditDAOImpl();
			if(logAndAuditDAO.save("Favorite Album", "User", String.valueOf(email))) {
				System.out.println("Favorite event inserted");
			}
			boolean flag=false;
			String sql="insert into favorite values('"+email+"','"+albumid+"')";
			try {
				con = DBConnectionUtil.openConnection();
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				flag = true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return flag;
		}

		@Override
		public List<Integer> getFavs(String email) {
			List<Integer> favslist=new ArrayList<Integer>();
			String sql="select * from favorite where email='"+email+"'";
			try {
				con = DBConnectionUtil.openConnection();
				statement= con.createStatement();
				rs=statement.executeQuery(sql);
				while(rs.next()) {
					favslist.add(rs.getInt(2));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return favslist;
		}

		@Override
		public boolean saveHistory(String email, int trackid) {
			LogAndAuditDAO logAndAuditDAO = null;
			logAndAuditDAO = new LogAndAuditDAOImpl();
			if(logAndAuditDAO.save("Song Played", "User", String.valueOf(email))) {
				System.out.println("History event inserted");
			}
				boolean flag = false;
				String sql = "insert into history(email,trackid) values('"+email+"','"+trackid+"')";
				try {
					con = DBConnectionUtil.openConnection();
					ps = con.prepareStatement(sql);
					ps.executeUpdate();
					flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return flag;
			}

		@Override
		public List<History> getHistory(String email) {
			LogAndAuditDAO logAndAuditDAO = null;
			logAndAuditDAO = new LogAndAuditDAOImpl();
			if(logAndAuditDAO.save("History Retrieve", "User", String.valueOf(email))) {
				System.out.println("Retrieve History event inserted");
			}
			History history = null;
			List<History> historylist = new ArrayList<History>();
			try {
				String sql = "select distinct hist.trackid,tracks.track_name,tracks.track_duration,perf.performer_name from history hist ,tbl_addtrack tracks, tbl_addperformer perf  where hist.trackid=tracks.track_no and tracks.track_performer=perf.performer_id and hist.email='"+email+"'";
				
				con = DBConnectionUtil.openConnection();
				statement= con.createStatement();
				rs=statement.executeQuery(sql);
				while(rs.next()) {
					history = new History();
					history.setTrackid(rs.getInt(1));
					history.setTrack_name(rs.getString(2));
					history.setTrack_duration(rs.getString(3));
					history.setPerformer_name(rs.getString(4));
					System.out.println(history.toString());
					historylist.add(history);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return historylist;
		}


	
}
