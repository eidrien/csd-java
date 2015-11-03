package org.agilar.csd.SRP.ExampleClass;

import com.google.gson.Gson;

public class DocumentSerializer {

	public  String serializeDocument(org.agilar.csd.SRP.ExampleClass.Document document) {
		Gson gsonParser = new Gson();
		return gsonParser.toJson(document);
	}

	
}
