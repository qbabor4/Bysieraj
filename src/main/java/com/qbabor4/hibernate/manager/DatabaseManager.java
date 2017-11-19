package com.qbabor4.hibernate.manager;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qbabor4.hibernate.model.Employee1;
import com.qbabor4.hibernate.model.PersonalData;
import com.qbabor4.hibernate.model.PersonalData2;
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
	
	public void oneToManyOk() {
		
		Employee1 emp = new Employee1();
		emp.setName("David");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		
		PersonalData personalData = new PersonalData();
		personalData.setEmail("email");
		personalData.setUsername("u2sername");
		
		emp.setPersonalData(personalData);
		personalData.setEmp1(emp);
		
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
	}
	
	public void UserPersonalData2() {
		User user = new User();
		user.setEmail("email@lol");
		user.setPasswd("passw");
		user.setUname("uname1");
		
		PersonalData2 personalData2 = new PersonalData2();
		personalData2.setMobile("897876543");
		personalData2.setName("alfred");
		personalData2.setSurname("ojojoj");
		
		user.setPersonalData2(personalData2);
		personalData2.setUser(user);
		
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(user);
		//Commit transaction
		session.getTransaction().commit();
	}
	
	
}
