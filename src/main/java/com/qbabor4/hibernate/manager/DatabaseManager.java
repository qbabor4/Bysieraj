package com.qbabor4.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qbabor4.hibernate.model.PasswdHistory;
import com.qbabor4.hibernate.model.PersonalData;
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
	
	
	public void UserPersonalData2() {
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
	
	public void UserPasswdHistory() {
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
	
	
}
