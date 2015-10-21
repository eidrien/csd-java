package org.agilar.csd.solid.DIP.ServiceLocator;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


import com.google.gson.Gson;

public class JsonInputParser extends InputParser{
	@Override
	 public Document ParseInput(File inputFile) 
	 {
		
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(inputFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String fileText = new String(encoded);
		
		Gson json = new Gson();
		return json.fromJson(fileText,Document.class);	
	 }

}
	