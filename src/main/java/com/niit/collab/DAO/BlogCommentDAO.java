package com.niit.collab.DAO;

import java.util.List;

import com.niit.collab.model.BlogComment;

public interface BlogCommentDAO {
	

	public boolean saveOrUpdate(BlogComment Blogcomment);
	public boolean delete(BlogComment Blogcomment);
	public List<BlogComment> list(int bid);

}
