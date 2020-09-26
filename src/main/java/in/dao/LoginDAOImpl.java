package in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.entity.User;
import in.util.DBConnectionUtil;

public class LoginDAOImpl implements LoginDAO{
	
	@Override
	public String authenticate(User user) {
		LogAndAuditDAO logAndAuditDAO = null;
		logAndAuditDAO = new LogAndAuditDAOImpl();
		if(logAndAuditDAO.save("Login Process", "User", String.valueOf(user.getEmail()))) {
			System.out.println("Login event inserted");
		}
		String sql =  "select * from tbl_user where email=? and password=?";
		
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,user.getEmail());
		ps.setString(2,user.getPassword());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			return "true";
		}
		else {
			return "false";
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
		
	}

}
