package org.luxoft.dao;

import java.util.LinkedList;
import org.luxoft.object.FileContent;
import org.luxoft.object.LineContent;

public interface FileDAO {

	public int writeFile(FileContent fileCon);

	public void writeContent(int id, LinkedList<LineContent> lineCon);
	
}

