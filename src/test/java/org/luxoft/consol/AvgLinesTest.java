package org.luxoft.consol;

import org.junit.Test;
import org.luxoft.object.FileContent;
import org.luxoft.object.LineContent;
import org.luxoft.parser.AvgLines;

import junit.framework.TestCase;

public class AvgLinesTest extends TestCase {

	AvgLines avgLines = new AvgLines();
	FileContent fileContent = new FileContent();
			
	@Test
	public void testApp()
    {	
		LineContent line1 = new LineContent();
		LineContent line2 = new LineContent();
		
		line1.setLineLength(10);
		line1.setLongWord("technical");
		line1.setShortWord("support");
		
		line2.setLineLength(5);
		line2.setLongWord("technical");
		line2.setShortWord("auto");
		
		fileContent.addLines(line1);
		fileContent.addLines(line2);
		
    	FileContent file = avgLines.avgValuesLines(fileContent);

    	assertEquals("technical", file.getLongWord());
    	assertEquals("auto", file.getShortWord());
    	assertEquals(10, file.getLineLength());
    }

}
