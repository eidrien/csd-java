package org.agilar.csd.solid.DIP.Manual;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class FormatConverter {

    
    private final InputParser inputParser;
    private final DocumentSerializer documentSerializer;
    private final DocumentStorageFactory documentStorageFactory;
    public FormatConverter(DocumentStorageFactory documentStorageFactory,InputParser inputParser, DocumentSerializer documentSerializer)
    {
        this.inputParser =inputParser;
        this.documentSerializer = documentSerializer;
        this.documentStorageFactory = documentStorageFactory;
    }

    public boolean ConvertFormat(String sourceFileName, String targetFileName) throws IOException, SAXException, ParserConfigurationException {
    	File input = null;
    	try
    	{
    		InputRetriever sourceDocumentStorage = documentStorageFactory.GetInputRetrieverForFileName(sourceFileName);
    		input = sourceDocumentStorage.GetData(sourceFileName);
        }
    	catch(Exception e)
    	{
    		return false;
    	}
        Document doc = inputParser.ParserInput(input);
        String serializedDoc = documentSerializer.Serialize(doc);

        try
        {
            DocumentPersister targetDocumentStorage = documentStorageFactory.GetDocumentPersisterForFileName(targetFileName);
            targetDocumentStorage.PersistDocument(serializedDoc, targetFileName);
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }
    
    
    
    
    
   
    
    

  
}