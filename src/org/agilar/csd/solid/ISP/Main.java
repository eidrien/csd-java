package org.agilar.csd.solid.ISP;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

   /* public static void main(String[] args) {
        try {
            String current    = new java.io.File( "." ).getCanonicalPath();
            String inputFile  = current + "\\Input Documents\\Document1.xml";
            String outputFile = current + "\\Output Documents\\Document1.json";
            boolean converted = false;
            FormatConverter converter = new FormatConverter();
            converted = converter.ConvertFormat(inputFile, outputFile);
            if (!converted)
            	System.out.println("KO");
            else
            	System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
    
    public static final String storageAccount ="csdagilar";
    public static final String storageKey ="e1niPCjt/i3bU/wllm4Bfqe9nP4JpAiCGEqAu+RqITwxF8K5jeZlIT7SGzZ+ah8WP3qfkRFeI8ivSjibOJffuA==";
    
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, InvalidKeyException, URISyntaxException {

            String current    = new File( "." ).getCanonicalPath();
            String sourceFileName  = current + "\\Output Documents\\Document1.json";
            String targetFileName = "https://csdagilar.blob.core.windows.net/csdagilar/DocumentAdri2.json";

            FormatConverter formatConverter = new FormatConverter();
            if (!formatConverter.ConvertFormat(sourceFileName, targetFileName)) {
                System.out.println("Conversion failed...");
            }
            else
                System.out.println("Conversion done...");
    }

	

	


}
