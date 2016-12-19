package com.niit.collab.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Blog {
	
	@Id
	@GeneratedValue
	private int id;
	private int userid;
	private String title;
	private Date doc;
	private String description;
	private int bloglike;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getDoc() {
		return doc;
	}
	public void setDoc(Date doc) {
		this.doc = doc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBloglike() {
		return bloglike;
	}
	public void setBloglike(int bloglike) {
		this.bloglike = bloglike;
	}
	
}
