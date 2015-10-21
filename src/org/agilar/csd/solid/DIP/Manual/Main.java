package org.agilar.csd.solid.DIP.Manual;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	
    public static final String storageAccount ="agilarcsd";
    public static final String storageKey ="wozZtmPCJc+qtQF6F1X0VHU1DIyxi8zy7gyN/Epe41g6OyfHGPrh6g/nk8nsQHF5wIG4pEJHZiS8n8IW0mx00w==";
    
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

            String current    = new File( "." ).getCanonicalPath();
           // String sourceFileName  = current + "/Input Documents/Document1.xml";
            String sourceFileName = current + "/Output Documents/Document1.json";
            
          //String sourceFileName = "http://chris.59north.com/Document1.xml";
            String targetFileName = "https://agilarcsd.blob.core.windows.net/agilarcsdcontainer/Document1.json";

            FormatConverter formatConverter = new FormatConverter();
            if (!formatConverter.ConvertFormat(sourceFileName, targetFileName)) {
                System.out.println("Conversion failed...");
            }
            else
                System.out.println("Conversion done...");
    }










}
