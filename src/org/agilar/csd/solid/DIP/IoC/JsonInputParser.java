package org.agilar.csd.solid.DIP.IoC;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.inject.Singleton;

@Singleton
public class JsonInputParser extends InputParser {
	
	
	@Override
	public org.agilar.csd.solid.DIP.IoC.Document ParserInput(File xmlFile) throws ParserConfigurationException, SAXException, IOException{

		byte[] encoded = null;
		encoded = Files.readAllBytes(xmlFile.toPath());
		String fileText = new String(encoded);
		Gson json = new Gson();
		return json.fromJson(fileText,Document.class);
		
	}

}
	