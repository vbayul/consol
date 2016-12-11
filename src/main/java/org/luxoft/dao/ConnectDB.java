package org.luxoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.luxoft.object.ParamDB;

public class ConnectDB {
	
	private ParamDB parametDB = new ParamDB();

	public ConnectDB()
	{
		GetParametrDB getParametrDB = new GetParametrDB();
		parametDB = getParametrDB.getParamDB();
	}
	
	public Connection getConnection() throws SQLException
	{
		try
		{
			Class.forName(parametDB.getDriver());
		}
		catch (ClassNotFoundException ex)
		{
			ex.getStackTrace();
		}
		
		return DriverManager.getConnection(parametDB.getUrl(), 
				parametDB.getUsername(), parametDB.getPassword());
	}
}
