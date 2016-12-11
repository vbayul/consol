package org.luxoft.parser;

import java.util.List;

import org.luxoft.object.FileContent;
import org.luxoft.object.LineContent;

public class LinesParsing {
	
	public FileContent parsingLines(FileContent fileContent, List<String> lines)
	{
		FileContent fileContentTemp = fileContent;
		
		for (String line : lines) 
		{
			LineContent fileLine = getParametrLine(line);
			fileContentTemp.addLines(fileLine);
		}

		return fileContentTemp;
	}

	private LineContent getParametrLine(String line)
	{
		LineContent fileLine = new LineContent();
	
		fileLine.setLineLength(line.length());
		fileLine.setAvgWord(avgWord(line));
		fileLine.setLongWord(longWord(line));
		fileLine.setShortWord(shortWord(line));
		
		return fileLine;
	}
	
	private String longWord(String line)
	{
		String[] lines = line.split(" ");
		String words = lines[0];
		
		for(String lineArray : lines )
		{
			if (words.length()<lineArray.length())
				words = lineArray;
		}
		return words;
	}
	
	private String shortWord(String line)
	{
		String[] lineArr = line.split(" ");
		String words = lineArr[0];
		
		for(String lineArray : lineArr )
		{
			if (words.length()>lineArray.length())
				words = lineArray;
		}
		return words;
	}
	
	private double avgWord(String line)
	{
		String[] lineArr = line.split(" ");
		
		double avg = 0;
		
		for(String lineArray : lineArr )
		{
			avg += lineArray.length();
		}
		
		return avg/lineArr.length;
	}
}