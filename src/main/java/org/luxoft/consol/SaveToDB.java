package org.luxoft.consol;


import java.sql.SQLException;

import org.luxoft.dao.ConnectDB;
import org.luxoft.dao.FileDAO;
import org.luxoft.dao.FileDAOImp;
import org.luxoft.object.FileContent;

public class SaveToDB {

	public void toDB(FileContent files)
	{
		ConnectDB conDB = new ConnectDB();
		
		try {
			FileDAO fileDAOimp = new FileDAOImp(conDB.getConnection());
			int id = fileDAOimp.writeFile(files);		
			fileDAOimp.writeContent(id, files.getLines());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
