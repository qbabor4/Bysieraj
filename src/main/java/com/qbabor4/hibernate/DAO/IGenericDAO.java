package com.qbabor4.hibernate.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Generic interface for Data Access Objects. TO be extended or implemented
 * Contains common persistence method
 * 
 * @author Jakub
 */
public interface IGenericDAO<T> {
	
	T save(T entity);
	
	T update(T entity);
	
	void delete(T entity);
	
	T findById(UUID id); 
	
	List<T> findAll();
	
	void flush();
}
