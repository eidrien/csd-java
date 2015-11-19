package org.agilar.csd.integrationTest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.agilar.csd.solid.DIP.Manual.DocumentSerializer;
import org.agilar.csd.solid.DIP.Manual.DocumentStorageFactory;
import org.agilar.csd.solid.DIP.Manual.FormatConverter;
import org.agilar.csd.solid.DIP.Manual.InputParser;
import org.agilar.csd.solid.DIP.Manual.JsonDocumentSerializer;
import org.junit.Test;
import org.xml.sax.SAXException;

public class FormatConverterShould {

	@Test
	public void Input_Xml_by_FileSystem_Output_Json_To_FileSystem()
			throws IOException, SAXException, ParserConfigurationException {
		String current;
		String sourceFileName = null;
		String targetFileName = null;

		current = new File(".").getCanonicalPath();
		sourceFileName = current + "/Input Documents/Document1.xml";
		targetFileName = current + "/Output Documents/Document1.json";

		InputParser xmlInputParser = new InputParser();
		DocumentSerializer documentSerializer = new JsonDocumentSerializer();

		FormatConverter formatConverter = new FormatConverter(xmlInputParser, documentSerializer);
		DocumentStorageFactory documentStorageFactory = new DocumentStorageFactory();
		boolean fileConverted = false;

		fileConverted = formatConverter.ConvertFormat(documentStorageFactory, sourceFileName, targetFileName);

		File fileOutput = new File(targetFileName);

		assertEquals(true, fileConverted);
		assertEquals(true, fileOutput.exists());

	}

}
