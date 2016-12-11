package org.luxoft.consol;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.luxoft.object.FileContent;
import org.luxoft.object.LineContent;
import org.luxoft.parser.LinesParsing;

import junit.framework.TestCase;

public class LinesParsingTest extends TestCase{

	LinesParsing lineParsing;
	List<String> testLines;
	FileContent line;
	
    @Test
    public void testApp()
    {
		
    	lineParsing = new LinesParsing();
    	testLines = new ArrayList<>();
    	line = new FileContent();
    	
    	testLines.add("auto technical support1");
    	
    	FileContent fileLine = lineParsing.parsingLines(line, testLines);
    	List<LineContent> lines = fileLine.getLines();
    	
        assertEquals(7.0, lines.get(0).getAvgWord());
        assertEquals(23, lines.get(0).getLineLength());
        assertEquals("technical", lines.get(0).getLongWord());
        assertEquals("auto", lines.get(0).getShortWord());
        
    }
}
