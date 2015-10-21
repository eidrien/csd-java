package org.agilar.csd.solid.ISP;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class FormatConverter {

    
    private final InputParser inputParser;
    private final DocumentSerializer documentSerializer;

    public FormatConverter()
    {
        inputParser = new JsonInputParser();
        documentSerializer = new CamelCaseJsonSerializer();
    }

    public boolean ConvertFormat(String sourceFileName, String targetFileName) throws IOException, SAXException, ParserConfigurationException {
    	File input = null;
    	try
    	{
    		InputRetriever sourceDocumentStorage = GetDocumentStorageForFileName(sourceFileName);
    		input = sourceDocumentStorage.GetData(sourceFileName);
        }
    	catch(Exception e)
    	{
    		return false;
    	}
        Document doc = inputParser.ParseInput(input);
        String serializedDoc = documentSerializer.Serialize(doc);

        try
        {
            DocumentPersister targetDocumentStorage = GetDocumentPersisterForFileName(targetFileName);
            targetDocumentStorage.PersistDocument(serializedDoc, targetFileName);
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }
    
    
    
    private InputRetriever GetDocumentStorageForFileName(String fileName)
    {

        if (IsBlobstorageUrl(fileName))
			try {
				return new BlobDocumentStorage(Main.storageAccount, Main.storageKey);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        if (fileName.startsWith("http"))
            return new HttpInputRetriever();

        return new FileDocumentStorage();
    }
    
    private DocumentPersister GetDocumentPersisterForFileName(String fileName)
    {
        if (IsBlobstorageUrl(fileName))
			try {
				return new BlobDocumentStorage(Main.storageAccount, Main.storageKey);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        return new FileDocumentStorage();
    }
    
    

    private boolean IsBlobstorageUrl(String str)
    {
       
        return str.startsWith(String.format("https://%s.blob.core.windows.net/", Main.storageAccount));
    }
}
