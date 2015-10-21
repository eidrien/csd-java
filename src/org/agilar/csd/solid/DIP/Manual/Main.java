package org.agilar.csd.solid.DIP.Manual;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.agilar.csd.solid.DIP.ServiceLocator.FormatConverterModule;
import org.xml.sax.SAXException;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

		String current = new File(".").getCanonicalPath();
		// String sourceFileName = current + "/Input Documents/Document1.xml";
		String sourceFileName = current + "/Output Documents/Document1.json";
		// String sourceFileName = "http://chris.59north.com/Document1.xml";
		String targetFileName = "https://agilarcsd.blob.core.windows.net/agilarcsdcontainer/Document1.json";

		//InputParser jsonInputParser = new JsonInputParser();
		//DocumentSerializer documentSerializer = new CamelCaseJsonSerializer();
		
		 Injector injector = Guice.createInjector(new FormatConverterModule());
		 FormatConverter formatConverter = injector.getInstance(FormatConverter.class);
		
	     DocumentStorageFactory documentStorageFactory = new DocumentStorageFactory();
		
		if (!formatConverter.ConvertFormat(documentStorageFactory,sourceFileName,targetFileName)) {
			System.out.println("Conversion failed...");
		} else
			System.out.println("Conversion done...");
	}
	
	

}
