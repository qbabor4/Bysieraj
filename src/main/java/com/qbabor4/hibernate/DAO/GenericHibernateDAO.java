package com.qbabor4.hibernate.DAO;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.qbabor4.hibernate.model.book.Publisher;

/** 
 * Provides generic common implementation of IGeanericDAO interface persistence methods.
 * Extend this abstract class to implement DAO for your specyfic entity
 * 
 * @author Jakub
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {
	
	private Class<T> hibernateClass;
	
	private Session session;
	
	public GenericHibernateDAO(Class<T> hibernateClass) {
		this.hibernateClass = hibernateClass;
	}
	
	protected Session getSession() {
		return session;
	}

	@PersistenceContext // co to robi? When the apliction starts we need to point Where to enter EntityManager implentation (zobaczyc czy jest takie do Session)
	public void setSession(Session session) {
		this.session = session;
	}

	public Class<T> getHibernateClass() {
		return hibernateClass;
	}
	
	public T save(T entity) {
		getSession().save(entity); // może tu z session.beginTransaction(); i commit ?
		return entity;
	}
		
	public T update(T entity) {
		getSession().merge(entity);
		return entity;
	}
	
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public T findById(ID id) { 
		return (T) getSession().get(getHibernateClass(), id);	
		// zrobić jakiegoś ifa jak instancja czegoś to zwróć
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
	
}
