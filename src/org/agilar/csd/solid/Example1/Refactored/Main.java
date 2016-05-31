package org.agilar.csd.solid.Example1.Refactored;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		try {
			
			String current = new java.io.File(".").getCanonicalPath();
			String inputFileName = current + "/Input Documents/Document1.xml";
			String outputFileName = current + "/Output Documents/Document1.json";

			File xmlFile = getInput(inputFileName);

			org.agilar.csd.solid.Example1.Refactored.Document document = getDocument(xmlFile);

			String json = serializeDocument(document);

			persistDocument(outputFileName, json);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void persistDocument(String outputFileName, String json) throws IOException {

		// write converted json data to a file named "file.json"
		FileWriter writer = new FileWriter(outputFileName);
		writer.write(json);
		writer.close();

	}

	private static String serializeDocument(org.agilar.csd.solid.Example1.Refactored.Document document) {
		Gson gsonParser = new Gson();
		return gsonParser.toJson(document);
	}

	private static org.agilar.csd.solid.Example1.Refactored.Document getDocument(File xmlFile)
			throws ParserConfigurationException, SAXException, IOException {

		org.agilar.csd.solid.Example1.Refactored.Document document = new org.agilar.csd.solid.Example1.Refactored.Document();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("document");

		Node nNode = nList.item(0);
		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			document.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
			document.setText(eElement.getElementsByTagName("text").item(0).getTextContent());
		}
		return document;
	}

	private static File getInput(String inputFileName) {
		return new File(inputFileName);
	}

}
