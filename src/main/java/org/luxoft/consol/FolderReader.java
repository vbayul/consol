package org.luxoft.consol;

import java.io.*;
import java.util.concurrent.*;
import org.luxoft.object.FileContent;
import org.luxoft.parser.Parser;

public class FolderReader implements Runnable{
	
	private File directory;
	private ExecutorService pool;
	
	public FolderReader(File directory, ExecutorService pool)
	{
		this.directory = directory;
		this.pool = pool;
	}

	@Override
	public void run() 
	{
		File[] files = directory.listFiles();

		for(File file : files)
			if(file.isDirectory())
			{
				FolderReader counter = new FolderReader(file, pool);
				pool.submit(counter);
			}
			else
			{
				Parser parsFile = new Parser();
				SaveToDB saveToDB = new SaveToDB();
				
				FileContent fileCon =  parsFile.getFileArribute(file);
				saveToDB.toDB(fileCon);
			}
	}
}