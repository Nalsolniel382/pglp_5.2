package fr.uvsq.pglp5_2;

import java.sql.SQLException;

import java.sql.DriverManager;


public abstract class BDD {

	
	   public static void createDataBase() throws SQLException {
	        DriverManager.getConnection(
	                "jdbc:derby:compositePattern;create=true");
	    }
	
	
}
