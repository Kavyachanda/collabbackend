package com.niit.collab.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.DAO.UserDAO;
import com.niit.collab.model.Blog;
import com.niit.collab.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@PostMapping(value="/register")
	public ResponseEntity<User> adduser(@RequestBody User user){
		System.out.println("hello");
		userDAO.saveOrUpdate(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	@GetMapping(value="/users")
	public ResponseEntity<List<User>> listuser(){
		System.out.println("list of users");
		List<User> user1 =userDAO.getAllUsers();
		return new ResponseEntity<List<User>>(user1,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/deleteuser/{userid}")
	public ResponseEntity<User> deleteuser(User user,@PathVariable("userid") int userid){
		User users1=userDAO.get(userid);
		userDAO.delete(users1);
		return new ResponseEntity<User>(user,HttpStatus.OK);
}
}