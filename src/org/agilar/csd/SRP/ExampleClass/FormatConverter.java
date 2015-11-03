package org.agilar.csd.SRP.ExampleClass;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class FormatConverter {

	DocumentStorage documentStorage = null;
	InputParser inputParser = null;
	DocumentSerializer documentSerializer = null;

	FormatConverter() {
		documentStorage = new DocumentStorage();
		inputParser = new InputParser();
		documentSerializer = new DocumentSerializer();
	}

	public boolean ConvertFormat(String inputFileName, String outputFileName)
			throws IOException, ParserConfigurationException, SAXException {
		try {
			File ficheroEntrada = documentStorage.getInput(inputFileName);
			org.agilar.csd.SRP.ExampleClass.Document documento = inputParser.getDocument(ficheroEntrada);
			String fileOutput = documentSerializer.serializeDocument(documento);
			documentStorage.persistDocument(outputFileName, fileOutput);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
