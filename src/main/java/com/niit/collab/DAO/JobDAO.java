package com.niit.collab.DAO;

import java.util.List;

import com.niit.collab.model.Job;

public interface JobDAO {
	
	public boolean saveOrUpdate(Job job);
	public boolean delete(Job job);
	public List<Job> list();
	public Job get(int id);

}