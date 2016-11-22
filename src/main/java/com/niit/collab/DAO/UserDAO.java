package com.niit.collab.DAO;

import java.util.List;

import com.niit.collab.model.User;

public interface UserDAO {

	public boolean saveOrUpdate(User user);
	public boolean delete(User user);
	public User get(int id);
	public List<User>  getAllUsers();
}
