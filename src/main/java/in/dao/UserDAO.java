package in.dao;

import java.util.List;


import in.entity.User;

public interface UserDAO {
	
 List<User> get();
 
 boolean save(User e);
 
 boolean update(String email,String password);
}
