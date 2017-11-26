package com.qbabor4.hibernate.main;

import java.util.List;

import com.qbabor4.hibernate.manager.DatabaseManager;
import com.qbabor4.hibernate.model.book.Publisher;


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
		DatabaseManager databaseManager = new DatabaseManager();
		databaseManager.startSession();

		databaseManager.userPersonalData2();
		databaseManager.userPasswdHistory();
		databaseManager.bookTwoPublisher();
		
		List<Publisher> publisherList = databaseManager.getPublisherByName("Seba");
		//System.out.println(publisherSeba.getCountry());
		for (Publisher publisher: publisherList) {
			System.out.println(publisher.getCity());
		}
		
		databaseManager.endSession();
	}
}
