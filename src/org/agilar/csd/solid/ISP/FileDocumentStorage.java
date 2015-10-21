package org.agilar.csd.solid.ISP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDocumentStorage extends DocumentStorage		
{
	@Override
	public File GetData(String fileName) {
	
	   return new File(fileName);
	}

	@Override
	public void PersistDocument(String serializedDocument, String targetFileName) {
		// TODO Auto-generated method stub
		 FileWriter writer;
		try {
			writer = new FileWriter(targetFileName);
			 writer.write(serializedDocument);
			 writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
