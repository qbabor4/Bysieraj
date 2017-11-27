package com.qbabor4.hibernate.DAO;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;

/** 
 * Provides generic common implementation of IGeanericDAO interface persistence methods.
 * Extend this abstract class to implement DAO for your specyfic entity
 * 
 * @author Jakub
 */
@Transactional // zobaczyc czy nie trzeba tego dawac w każdym DAO
public abstract class GenericHibernateDAO<T> implements IGenericDAO<T> {
	
	private Class<T> hibernateClass;
	
	private Session session;
	
	public GenericHibernateDAO(Class<T> hibernateClass) {
		this.hibernateClass = hibernateClass;
	}
	
	protected Session getSession() {
		if (session == null)  
            throw new IllegalStateException("Session has not been set on DAO before usage");  
        return session;  
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Class<T> getHibernateClass() {
		return hibernateClass;
	}
	
	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity); // może tu z session.beginTransaction(); i commit ?
		return entity;
	}
		
	public T merge(T entity) {
		getSession().merge(entity);
		return entity;
	}
	
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public T findById(UUID id) { 
		return (T) getSession().get(getHibernateClass(), id);	
		// zrobić jakiegoś ifa jak instancja czegoś to zwróć (bo ma problemy z unchecked...)
	}
	
	public List<T> findAll(){
		Criteria criteria = session.createCriteria(getHibernateClass());
		final List<T> TList = new LinkedList<>();
		for (final Object o : criteria.list()) {
			TList.add((T) o);
		}
		
		return TList;
	}
	
	public void flush() {
		getSession().flush();
	}
	

    public void clear() {  
        getSession().clear();  
    }  
	
}
