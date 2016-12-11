package org.luxoft.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.luxoft.object.ParamDB;

public class GetParametrDB {

	private ParamDB parametrDB = new ParamDB(); 
	
	public GetParametrDB()
	{
		Properties props = new Properties();

		try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
		{
			props.load(in);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		String driver = props.getProperty("jdbc.drivers");
		if (driver != null)
			System.setProperty("jdbc.drivers", driver);
		
		parametrDB.setDriver(driver);
		parametrDB.setUrl(props.getProperty("jdbc.url"));
		parametrDB.setUsername(props.getProperty("jdbc.username"));
		parametrDB.setPassword(props.getProperty("jdbc.password"));
	}
	
	public ParamDB getParamDB()
	{
		return parametrDB;
	}
}
