package org.luxoft.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.luxoft.object.FileContent;

public class Parser {

	LinesParsing parsLine; 
	FileContent fileCon; 
	AvgLines parsLines; 
	
	public FileContent getFileArribute(File file)
	{
		parsLine = new LinesParsing();
		fileCon = new FileContent();
		parsLines = new AvgLines(); 
		
		fileCon.setFileName(file.getName());
		
		List<String> lines = readLensFromFile(file);
		
		fileCon = parsLine.parsingLines(fileCon, lines);

		fileCon = parsLines.avgValuesLines(fileCon);
		
		return fileCon;
	}
	
	private List<String> readLensFromFile(File file)
	{		
		List<String> lines = new ArrayList<>();
		
		try (Scanner in = new Scanner(file))
		{
			while (in.hasNextLine())
			{
				lines.add(in.nextLine());

			}
		}
		catch (IOException e)
		{
			e.getStackTrace();
		}
		return lines;
	}
}
