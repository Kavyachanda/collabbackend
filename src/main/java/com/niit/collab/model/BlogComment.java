package com.niit.collab.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class BlogComment {

	@Id
	@GeneratedValue
	private int id;
	private int userid;
	private int blogid;
	@Column(name="comments")
	private String comment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getblogid() {
		return blogid;
	}
	public void setblogid(int blogid) {
		this.blogid = blogid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(Date commenttime) {
		this.commenttime = commenttime;
	}
	private Date commenttime;

}
