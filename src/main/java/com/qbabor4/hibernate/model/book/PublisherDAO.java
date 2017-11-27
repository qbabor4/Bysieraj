package com.qbabor4.hibernate.model.book;

import com.qbabor4.hibernate.DAO.GenericHibernateDAO;

public class PublisherDAO extends GenericHibernateDAO<Publisher>{

	public PublisherDAO(Class<Publisher> hibernateClass) { // to może jakoś inaczej można??
		super(hibernateClass);
	
	}



}
