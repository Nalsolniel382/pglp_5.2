package fr.uvsq.pglp5_2;

import java.sql.SQLException;

import java.sql.DriverManager;


public abstract class BDD {

	  public static void creeBDD() throws SQLException {
	      
		 DriverManager.getConnection("jdbc:derby:BDD;create=true");
	  }
	
}
