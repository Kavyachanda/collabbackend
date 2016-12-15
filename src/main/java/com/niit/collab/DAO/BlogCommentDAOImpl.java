package com.niit.collab.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.BlogComment;
import com.niit.collab.model.ForumComment;

@Repository(value="blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(BlogComment blogcomment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogcomment);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public boolean delete(BlogComment blogcomment) {
		try {
			sessionFactory.getCurrentSession().delete(blogcomment);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<BlogComment> list(int bid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(BlogComment.class);
		c.add(Restrictions.eq("blogid", bid));
		List<BlogComment> list=c.list();
		return list;
	}
}