package org.agilar.csd.SRP.ExampleClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentStorage {
	
	
	public  File getInput(String inputFileName) {
		return new File(inputFileName);
	}
	
	public void persistDocument(String outputFileName, String json) throws IOException {

		// write converted json data to a file named "file.json"
		FileWriter writer = new FileWriter(outputFileName);
		writer.write(json);
		writer.close();

	}

	
	
}
