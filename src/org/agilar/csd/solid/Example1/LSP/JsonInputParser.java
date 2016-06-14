package org.agilar.csd.solid.Example1.LSP;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.google.gson.Gson;

public class JsonInputParser extends InputParser {
	
	@Override
	public org.agilar.csd.solid.Example1.LSP.Document ParserInput(File xmlFile) throws ParserConfigurationException, SAXException, IOException{

		byte[] encoded = null;
		
	    encoded = Files.readAllBytes(xmlFile.toPath());
		String fileText = new String(encoded);
		
		Gson json = new Gson();
		return json.fromJson(fileText,Document.class);
		
	}

}
	