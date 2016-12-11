package org.luxoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.luxoft.object.FileContent;
import org.luxoft.object.LineContent;

public class FileDAOImp implements FileDAO {

	private Connection connection;
	
	public FileDAOImp(Connection connetction)
	{
		this.connection = connetction;
	}
	
	@Override
	public int writeFile(FileContent files)  
	{				
		String sql = "INSERT INTO `file` "
				+ "(namefile,longWord,shortWord,lineLength) "
				+ "VALUES(?,?,?,?);";
		
		try (PreparedStatement st = connection.prepareStatement(sql))
		{
			st.setString(1, files.getFileName());
			st.setString(2, files.getLongWord());
			st.setString(3, files.getShortWord());
			st.setInt(4, files.getLineLength());
			st.execute();

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		sql = "SELECT last_insert_id() AS idfile;";
		try (PreparedStatement st = connection.prepareStatement(sql))
		{
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			
			return id;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void writeContent(int id, LinkedList<LineContent> lines) {

		String sql = "INSERT INTO `luxoft`.`line`"
				+ "(`idfile`,`longWord`,`shortWord`,`lineLength`,`avgWord`) "
				+ "VALUES (?,?,?,?,?);";

		try (PreparedStatement st = connection.prepareStatement(sql))
		{
			LineContent line = new LineContent();
		
			for (int i = 0; i < lines.size();i++)
			{
				line = lines.get(i);
			
				st.setInt(1, id);
				st.setString(2, line.getLongWord());
				st.setString(3, line.getShortWord());
				st.setInt(4, line.getLineLength());
				st.setDouble(5, line.getAvgWord());
				st.execute();
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
}