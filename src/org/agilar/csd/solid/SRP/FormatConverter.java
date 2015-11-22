package org.agilar.csd.solid.SRP;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class FormatConverter {

	InputParser inputParser  = null;
	DocumentSerializer documentSerializer = null;
	DocumentStorage documentStorage = null;
	
	public FormatConverter()
	{
		inputParser = new InputParser();
		documentSerializer = new DocumentSerializer();
		documentStorage = new DocumentStorage();
	}
	public boolean ConvertFormat(String sourceFilename, String targetFilename) throws IOException, ParserConfigurationException, SAXException
	{
		
	    boolean converted = false;
		File xmlFile =  documentStorage.GetData(sourceFilename);
	    Document document = inputParser.ParserInput(xmlFile);
	   
	    String jsonFile = documentSerializer.Serialize(document);
	    documentStorage.PersistDocument(jsonFile, targetFilename);
	    return converted;
	   
	    
	}

}

