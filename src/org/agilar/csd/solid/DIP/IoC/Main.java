package org.agilar.csd.solid.DIP.IoC;

import java.io.File;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static final String storageAccount ="csdagilar";
    public static final String storageKey ="e1niPCjt/i3bU/wllm4Bfqe9nP4JpAiCGEqAu+RqITwxF8K5jeZlIT7SGzZ+ah8WP3qfkRFeI8ivSjibOJffuA==";
    
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, InvalidKeyException, URISyntaxException {

            String current    = new File( "." ).getCanonicalPath();
            String sourceFileName  = current + "\\Output Documents\\Document1.json";
            //String targetFileName = "https://csdagilar.blob.core.windows.net/csdagilar/DocumentAdri2.json";
            String targetFileName = current + "\\Output Documents\\Document1.json";
            Injector injector = Guice.createInjector(new FormatConverterModule());        
            FormatConverter formatConverter = injector.getInstance(FormatConverter.class);
            if (!formatConverter.ConvertFormat(sourceFileName, targetFileName)) {
                System.out.println("Conversion failed...");
            }
            else
                System.out.println("Conversion done...");
    }

	

	


}
