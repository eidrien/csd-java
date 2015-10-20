package org.agilar.csd.solid.SRP;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

            String current    = new File( "." ).getCanonicalPath();
            String sourceFileName  = current + "/Input Documents/Document1.xml";
            String targetFileName = current + "/Output Documents/Document1.json";

            FormatConverter formatConverter = new FormatConverter();
            if (!formatConverter.ConvertFormat(sourceFileName, targetFileName)) {
                System.out.println("Conversion failed...");
            }
            else
                System.out.println("Conversion done...");
    }










}
