package org.agilar.csd.solid.Example1.DIP.Manual;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public  class FileDocumentStorage extends DocumentStorage 
{
	@Override
	public File GetData(String Filename) {
		
		File xmlFile = new File(Filename);
		return xmlFile;
	}
    @Override
	public void PersistDocument(String serializeDocument, String targetFilename) throws IOException {
		FileWriter writer = new FileWriter(targetFilename );
	    writer.write(serializeDocument);
	    writer.close();	
	}

}
