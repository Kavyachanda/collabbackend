package com.niit.collab.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Blog;
import com.niit.collab.model.User;

@Repository
public class UserDAOImpl implements UserDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	
	@Transactional
	public boolean saveOrUpdate(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<User> getAllUsers() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(User.class);
		List<User> list = c.list();
		return list;
		
	/*	String hql = "from User" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();*/
	}

	@Transactional
	public User get(int id) {
		String hql = "from User where userid= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
		
		/*return (User) sessionFactory.getCurrentSession().get(User.class , id);*/
		
	}
	
	@Transactional
	public List<User> getuser(int id) {
		String hql = "from User where userid= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list;
		}
		
		/*return (User) sessionFactory.getCurrentSession().get(User.class , id);*/
		
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	@Transactional
	public User authuser(String username, String password) {
		String hql="from User where username= "+"'"+username+"'"+"and password= "+"'"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list=query.list();
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public User logout(int id) {
		String hql = "from User where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	
	}
	
	@Transactional
	public User profileof(String username) {
		String hql="from User where username='"+username+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	
	@Transactional
	public List<User> nonfriends(int id) {
		String hql = "from User where id !='"+id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list= query.list();
		return list;
	}

}

