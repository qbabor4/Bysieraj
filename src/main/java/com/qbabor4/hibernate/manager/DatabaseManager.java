package com.qbabor4.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qbabor4.hibernate.enums.BookAvability;
import com.qbabor4.hibernate.model.Book;
import com.qbabor4.hibernate.model.PasswdHistory;
import com.qbabor4.hibernate.model.PersonalData;
import com.qbabor4.hibernate.model.Publisher;
import com.qbabor4.hibernate.model.User;
import com.qbabor4.hibernate.util.HibernateUtil;

public class DatabaseManager {
	SessionFactory sessionFactory;
	Session session;
	
	public void startSession() {
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
	}
	
	public void endSession() {
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}
	
	
	public void userPersonalData2() {
		User user = new User();
		user.setEmail("email@lol");
		user.setPasswd("passw");
		user.setUname("uname1");
		
		PersonalData personalData = new PersonalData();
		personalData.setMobile("897876543");
		personalData.setName("alfred");
		personalData.setSurname("ojojoj");
		
		user.setPersonalData(personalData);
		personalData.setUser(user);
		
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(user);
		//Commit transaction
		session.getTransaction().commit();
	}
	
	public void userPasswdHistory() {
		User user = new User();
		user.setEmail("emai3@lol");
		user.setPasswd("pas4w");
		user.setUname("una2e1");
		
		PasswdHistory passwdHistory = new PasswdHistory();
		passwdHistory.setPasswd("pas4w");
		
		user.setPasswdHistory(passwdHistory);
		passwdHistory.setUser(user);
		
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(user);
		//Commit transaction
		session.getTransaction().commit();
	}
	
	public void bookPublisher() {
		Book book = new Book();
		book.setBookAvability(BookAvability.DOSTEPNA);
		book.setIsbn("isbn:2345");
		book.setTitle("w puszczy i w puszczy");
		
		Publisher publisher = new Publisher();
		publisher.setCity("NY");
		publisher.setCountry("Music");
		publisher.setName("Alfred");
		
		book.setPublisher(publisher);
		
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(book);
		//Commit transaction
		session.getTransaction().commit();
		
	}
	
	public void bookTwoPublisher() {
		Book book = new Book();
		book.setBookAvability(BookAvability.SERWIS);
		book.setIsbn("isbn:2345");
		book.setTitle("pan taboret");
		
		Book book2 = new Book();
		book2.setBookAvability(BookAvability.DOSTEPNA);
		book2.setIsbn("isbn:fr345");
		book2.setTitle("w puszczy i w jeszcze wiekszej puszczy");
		
		Publisher publisher = new Publisher();
		publisher.setCity("CHORZÓW");
		publisher.setCountry("POLAND");
		publisher.setName("Seba");
		
		book.setPublisher(publisher);
		book2.setPublisher(publisher);
		
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(book);
		session.save(book2);
		//Commit transaction
		session.getTransaction().commit();
		
	}
	
	
}
