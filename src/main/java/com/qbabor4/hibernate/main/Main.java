package com.qbabor4.hibernate.main;

import org.hibernate.Session;

import com.qbabor4.hibernate.enums.BookAvability;
import com.qbabor4.hibernate.enums.BookQuality;
import com.qbabor4.hibernate.model.book.Author;
import com.qbabor4.hibernate.model.book.Book;
import com.qbabor4.hibernate.util.HibernateUtil;


/**
 * 
 * Co jak dodam sam personalData bez usera
 * zrobić DAO do encji
 * dostac uuid i porównać czy jest takie same jak przed wyciagnieciem z tabeli (może ucinać)
 * Czym sie różni obustronna od jednostronnej?
 * łapać jak ktś nie poda notnulla
 * zwracanie listy ksiazek autora i journali
 * update 
 * zrobić dao do publishera (jak dac tam session facotry?) Generyki? (bez autowired)
 * Jak dobrze uzywac DAO
 * 
 * Jak zrobić tego autora, żeby było tylko po stronie bazy??? bedzie wiele do wielu relacja
 * 
 * Pomysły:
 * Może name w publisher bedzie unique? (po czym trzeba szukac)
 * Description w book dłuższe?
 * birth w autorze jako data?
 * @author Jakub
 *
 */
public class Main 
{
	public static void main(String[] args) {
//		DatabaseManager databaseManager = new DatabaseManager();
//		databaseManager.startSession();
//
//		databaseManager.userPersonalData2();
//		databaseManager.userPasswdHistory();
//		databaseManager.bookTwoPublisher();
//		
//		List<Publisher> publisherList = databaseManager.getPublisherByName("Seba");
//		//System.out.println(publisherSeba.getCountry());
//		for (Publisher publisher: publisherList) {
//			System.out.println(publisher.getCity());
//		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		
//		Publisher pub = new Publisher();
//		pub.setCity("NY");
//		pub.setName("albert");
//		pub.setCountry("America Baby!");
//		
//		PublisherDAO pDAO = new PublisherDAO(Publisher.class);
//		pDAO.setSession(session);
//		session.beginTransaction();
//		pDAO.saveOrUpdate(pub);
//		session.getTransaction().commit();
		
		Author a1 = new Author();
		a1.setName("Alf");
		a1.setBirth(2345);
		a1.setSurname("sername1");
		Author a2 = new Author();
		a2.setName("ergerg");
		a2.setBirth(234545);
		a2.setSurname("serfme1");
		
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
		
		a1.getBookEntities().add(book);
		a1.getBookEntities().add(book2);
		
		book.getAuthorEntities().add(a1);
		book.getAuthorEntities().add(a2);
		
		session.beginTransaction();
		// Save the Model object
		session.save(book);
		session.save(book2);
		// Commit transaction
		session.getTransaction().commit();
		
		HibernateUtil.getSessionFactory().close();
//		databaseManager.endSession();
	}
}
