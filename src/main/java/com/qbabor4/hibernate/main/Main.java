package com.qbabor4.hibernate.main;

import com.qbabor4.hibernate.manager.DatabaseManager;


/**
 * 
 * Co jak dodam sam personalData bez usera
 * zrobić DAO do encji
 * 
 * @author Jakub
 *
 */
public class Main 
{
	public static void main(String[] args) {
		DatabaseManager databaseManager = new DatabaseManager();
		databaseManager.startSession();

		//databaseManager.UserPersonalData2();
		databaseManager.UserPasswdHistory();
		
		databaseManager.endSession();
	}
}
