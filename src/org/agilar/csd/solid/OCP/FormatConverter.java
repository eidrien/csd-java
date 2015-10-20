package org.agilar.csd.solid.OCP;


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
    		DocumentStorage sourceDocumentStorage = GetDocumentStorageForFileName(sourceFileName);
    		input = sourceDocumentStorage.GetData(sourceFileName);
        }
    	catch(Exception e)
    	{
    		
    	}
        Document doc = inputParser.ParseInput(input);
        String serializedDoc = documentSerializer.Serialize(doc);

        try
        {
            DocumentStorage targetDocumentStorage = GetDocumentStorageForFileName(targetFileName);
            targetDocumentStorage.PersistDocument(serializedDoc, targetFileName);
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }
    
    
    
    private DocumentStorage GetDocumentStorageForFileName(String fileName)
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

    private boolean IsBlobstorageUrl(String str)
    {
       
        return str.startsWith(String.format("https://%s.blob.core.windows.net/", Main.storageAccount));
    }
}
