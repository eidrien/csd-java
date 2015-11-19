package org.agilar.csd.integrationTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import junit.framework.AssertionFailedError;

import org.agilar.csd.solid.DIP.Manual.CamelCaseJsonSerializer;
import org.agilar.csd.solid.DIP.Manual.DocumentSerializer;
import org.agilar.csd.solid.DIP.Manual.DocumentStorageFactory;
import org.agilar.csd.solid.DIP.Manual.FormatConverter;
import org.agilar.csd.solid.DIP.Manual.InputParser;
import org.agilar.csd.solid.DIP.Manual.JsonDocumentSerializer;
import org.agilar.csd.solid.DIP.Manual.JsonInputParser;

public class FormatConverterShould {

	@Test
	public void InputXmlFileSystemOutputJsonFileSystem() {
		String current;
		String sourceFileName;
		String targetFileName;
	
		try {
			 current = new File(".").getCanonicalPath();
			 sourceFileName = current + "/Input Documents/Document1.xml";
		     targetFileName = current + "/Output Documents/Document1.json";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fail();
		}
		
		
		InputParser xmlInputParser = new InputParser();
		DocumentSerializer documentSerializer = new JsonDocumentSerializer();
		
		FormatConverter formatConverter = new FormatConverter(xmlInputParser,documentSerializer);
		DocumentStorageFactory documentStorageFactory = new DocumentStorageFactory();
		boolean fileConverted;
		try {
			fileConverted = formatConverter.ConvertFormat(documentStorageFactory,sourceFileName,targetFileName);
		} catch (IOException | SAXException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fileOutput = new File(targetFileName);
			
		assertEquals(true, fileConverted);
		assertEquals(true,fileOutput.exists());
		
		
	}

}
