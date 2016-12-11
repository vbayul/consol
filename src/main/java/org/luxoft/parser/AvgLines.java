package org.luxoft.parser;

import java.util.LinkedList;
import java.util.List;

import org.luxoft.object.FileContent;
import org.luxoft.object.LineContent;

public class AvgLines {

	private String longWord;
	private String shortWord;
	private int line;
	
	public FileContent avgValuesLines(FileContent fileContent)
	{
		List<LineContent> lines = new LinkedList<>();
		lines = fileContent.getLines();
		
		LineContent fLine = lines.get(0);
		longWord = fLine.getLongWord();
		shortWord = fLine.getShortWord();
		line = fLine.getLineLength();
		
		for (int i = 0; i<lines.size(); i++)
		{
			fLine = lines.get(i);
			longWord = max(longWord, fLine.getLongWord());
			shortWord = min(shortWord , fLine.getShortWord());
			if (line <= fLine.getLineLength())
				line = fLine.getLineLength();
		}
		
		fileContent.setLongWord(longWord);
		fileContent.setShortWord(shortWord);
		fileContent.setLineLength(line);

		return fileContent;
	}

	private String max(String line1, String line2)
	{
		if (line1.length()<line2.length())
			return line2;
		else 
			return line1;
	}
	
	private String min(String line1, String line2)
	{
		if (line1.length()>line2.length())
			return line2;
		else 
			return line1;
	}
}
