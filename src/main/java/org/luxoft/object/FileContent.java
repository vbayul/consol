package org.luxoft.object;


import java.util.LinkedList;

public class FileContent {

	private String fileName; 
	private String longWord;
	private String shortWord;
	private int lineLength;
	private LinkedList<LineContent> lines = new LinkedList<>();
	
	public String getLongWord() {
		return longWord;
	}

	public void setLongWord(String longWord) {
		this.longWord = longWord;
	}

	public String getShortWord() {
		return shortWord;
	}

	public void setShortWord(String shortWord) {
		this.shortWord = shortWord;
	}

	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LinkedList<LineContent> getLines() {
		return lines;
	}
	
	public void addLines(LineContent fileLine)
	{
		lines.add(fileLine);
	}
}
