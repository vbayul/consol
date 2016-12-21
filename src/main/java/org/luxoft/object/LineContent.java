package org.luxoft.object;

public class LineContent {

	private String longWord;
	private String shortWord;
	private int lineLength;

	private double avgWord;
	
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
	public double getAvgWord() {
		return avgWord;
	}
	public void setAvgWord(double avgWord) {
		this.avgWord = avgWord;
	}
}