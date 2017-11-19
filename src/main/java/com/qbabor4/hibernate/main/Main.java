package com.qbabor4.hibernate.main;

import com.qbabor4.hibernate.manager.DatabaseManager;


/**
 * 
 * Co jak dodam sam personalData bez usera
 * 
 * 
 * @author Jakub
 *
 */
public class Main 
{
	public static void main(String[] args) {
		DatabaseManager databaseManager = new DatabaseManager();
		
		databaseManager.startSession();
		//databaseManager.oneToManyOk();
		databaseManager.UserPersonalData2();
		
		databaseManager.endSession();
	}
}
