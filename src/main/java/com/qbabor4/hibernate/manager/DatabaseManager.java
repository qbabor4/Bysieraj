package com.qbabor4.hibernate.manager;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.qbabor4.hibernate.enums.BookAvability;
import com.qbabor4.hibernate.enums.BookQuality;
import com.qbabor4.hibernate.model.book.Book;
import com.qbabor4.hibernate.model.book.Publisher;
import com.qbabor4.hibernate.model.user.PasswdHistory;
import com.qbabor4.hibernate.model.user.PersonalData;
import com.qbabor4.hibernate.model.user.User;
import com.qbabor4.hibernate.util.HibernateUtil;

public class DatabaseManager {

	SessionFactory sessionFactory;
	Session session;

	public void startSession() {
		// Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		// session = sessionFactory.getCurrentSession();
		session = sessionFactory.openSession();
	}

	public void endSession() {
		// terminate session factory, otherwise program won't end
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

		// start transaction
		session.beginTransaction();
		// Save the Model object
		session.save(user);
		// Commit transaction
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

		// start transaction
		session.beginTransaction();
		// Save the Model object
		session.save(user);
		// Commit transaction
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

		// start transaction
		session.beginTransaction();
		// Save the Model object
		session.save(book);
		// Commit transaction
		session.getTransaction().commit();

	}

	public void bookTwoPublisher() {
		Book book = new Book();
		book.setBookAvability(BookAvability.SERWIS);
		book.setIsbn("isbn:2345");
		book.setTitle("pan taboret");
		book.setYear(2005);
		book.setEdition("Edycja 1");
		book.setDescription("Wciągająca książka o taborecie");
		book.setQuality(BookQuality.DOBRA);
		book.setSignature("A podpisze, co mi tam");
		book.setBookComment("komentarz");

		Book book2 = new Book();
		book2.setBookAvability(BookAvability.DOSTEPNA);
		book2.setIsbn("isbn:fr345");
		book2.setTitle("w puszczy i w jeszcze wiekszej puszczy");
		book2.setYear(2023);
		book2.setEdition("Edycja 3");
		book2.setDescription("Wciągająca książka o puszczalskiej puszczy");
		book2.setQuality(BookQuality.USZKODZONA);
		book2.setSignature("Eee panie nie ma głupich, nie podpisuję..");
		book2.setBookComment("komentarz 3");

		Publisher publisher = new Publisher();
		publisher.setCity("CHORZÓW");
		publisher.setCountry("POLAND");
		publisher.setName("Seba");
		
		Publisher publisher2 = new Publisher();
		publisher2.setCity("GDYNIA");
		publisher2.setCountry("POLAND");
		publisher2.setName("Seba");

		book.setPublisher(publisher);
		book2.setPublisher(publisher2);

		// start transaction
		session.beginTransaction();
		// Save the Model object
		session.save(book);
		session.save(book2);
		// Commit transaction
		session.getTransaction().commit();

	}

	public List<Publisher> getPublisherByName(String name) {
		Criteria criteria = session.createCriteria(Publisher.class);
		criteria.add(Restrictions.eq("name", name));
		
		final List<Publisher> publisherList = new LinkedList<>();
		for (final Object o : criteria.list()) {
			publisherList.add((Publisher) o);
		}
		
		return publisherList;
	}

}
