package org.agilar.csd.solid.DIP.Manual;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InputParser {
 
	public org.agilar.csd.solid.DIP.Manual.Document ParserInput(File xmlFile) throws ParserConfigurationException, SAXException, IOException{
		
		org.agilar.csd.solid.DIP.Manual.Document document = new org.agilar.csd.solid.DIP.Manual.Document();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("document");

		Node nNode = nList.item(0);
		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE )
		{
		    Element eElement = (Element) nNode;
		    document.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
		    document.setText( eElement.getElementsByTagName("text").item(0).getTextContent());
		}
		return document;
	}

	
}
