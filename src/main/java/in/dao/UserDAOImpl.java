package in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.entity.User;
import in.util.DBConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;

	@Override
	public List<User> get() {
				
		List<User> list = null;
		User user = null;
		try {
			list = new ArrayList<User>();
			String sql = "SELECT * FROM tbl_user";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				user = new User();
				//user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));
				System.out.println(user.toString());
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	@Override
	public boolean save(User e) {
		boolean flag = false;
		try {
			
			String sql = "INSERT INTO tbl_user(username, email, password)VALUES"
					+ "('"+e.getUsername()+"', '"+e.getEmail()+"', '"+e.getPassword()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
		
	}
	@Override
	public boolean update(String email,String password) {
		boolean flag = false;
		try {
			String sql = "update tbl_user set password='"+password+"' where email='"+email+"'";
			connection = DBConnectionUtil.openConnection();
			preparedStatement =  connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	

}
