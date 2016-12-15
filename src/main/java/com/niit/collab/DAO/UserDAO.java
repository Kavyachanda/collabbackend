package com.niit.collab.DAO;

import java.util.List;

import com.niit.collab.model.User;

public interface UserDAO {

	public boolean saveOrUpdate(User user);
	public boolean delete(User user);
	public User get(int id);
	public List<User>  getAllUsers();
	public List<User> getuser(int id);
	public User logout(int id);
	public User authuser(String username,String password);
	public User profileof(String username);
	public List<User> nonfriends(int id);
}
