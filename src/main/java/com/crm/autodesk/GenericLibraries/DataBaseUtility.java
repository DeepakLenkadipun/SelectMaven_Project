package com.crm.autodesk.GenericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic method to read data from database
 * @author DEEPAK LENKA
 *
 */
public class DataBaseUtility {
	Connection con=null;
	Driver driverRef;
	ResultSet result=null;
	/**
	 * @throws Throwable 
	 * connection with database is established
	 */
	public void connectToDatabase() throws Throwable {
       DriverManager.registerDriver(driverRef);
	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
	}
	/**
	 * DB connection is closed
	 * @throws Throwable 
	 * 
	 */
	public void closeDb() throws Throwable {
		con.close();
	}
	/**
	 * This method returns the data wrt column index
	 * 
	 * @return
	 * @throws Throwable 
	 */
	public String getDataFromDB(String query,int Columindex) throws Throwable {
		String value=null;
		result=con.createStatement().executeQuery(query);
		while(result.next()) {
			value=result.getString(Columindex);
			
		}
		return value;
		
	}

}



























