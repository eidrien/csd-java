package org.agilar.csd.solid.SRP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentStorage 
{
	
	public File GetData(String fileName)
	{
	
		File xmlFile = new File(fileName);
		return xmlFile;
	}
	
	public void PersistDocument(String serializeDocument,String targetFilename) throws IOException
	{
		FileWriter writer = new FileWriter(targetFilename );
        writer.write(serializeDocument);
        writer.close();	
	}

}
