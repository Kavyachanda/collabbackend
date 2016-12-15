package com.niit.collab.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.DAO.BlogCommentDAO;
import com.niit.collab.model.BlogComment;



@RestController
public class BlogCommentController {

	@Autowired
	private BlogCommentDAO blogCommentDAO;
	
	@PostMapping(value="/commentblog/{bid}")
	public ResponseEntity<BlogComment> blogcomment(@RequestBody BlogComment blogcomment,HttpSession session,@PathVariable("bid") int bid){
		int uid=(Integer) session.getAttribute("uid");
		blogcomment.setId(bid);
		blogcomment.setUserid(uid);
		blogcomment.setCommenttime(new Date());
		blogCommentDAO.saveOrUpdate(blogcomment);
		return new ResponseEntity<BlogComment>(blogcomment,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getblogcomment/{bid}")
	public ResponseEntity<List<BlogComment>> getcomment(@PathVariable("bid") int bid){
		List<BlogComment> comments =blogCommentDAO.list(bid);
		return new ResponseEntity<List<BlogComment>>(comments,HttpStatus.OK);
	}
}