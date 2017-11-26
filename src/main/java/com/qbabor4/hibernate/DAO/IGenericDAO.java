package com.qbabor4.hibernate.DAO;

import java.io.Serializable;
import java.util.List;

/**
 * Generic interface for Data Access Objects. TO be extended or implemented
 * Contains common persistence method
 * 
 * @author Jakub
 */
public interface IGenericDAO<T, ID extends Serializable> {
	
	T save(T entity);
	
	T update(T entity);
	
	void delete(T entity);
	
	T findById(ID id); // tu jak zawssze bedzie uuid, to może nie podawać na górze typu id 
	
	List<T> findAll();
	
	void flush();
}
