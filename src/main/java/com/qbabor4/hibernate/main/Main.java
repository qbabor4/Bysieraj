package com.qbabor4.hibernate.main;

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
 * 
 * Pomysły:
 * Może name w publisher bedzie unique? (po czym trzeba szukac)
 * Description w book dłuższe?
 * Dlaczgo w book nie ma odniesienia do autora?
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
		
		Publisher publisherSeba = databaseManager.getPublisherByName("Seba");
		System.out.println(publisherSeba.getCountry());
		
		databaseManager.endSession();
	}
}
