package org.agilar.csd.solid.LSP;

import com.google.gson.Gson;

public class JsonDocumentSerializer implements DocumentSerializer {

	public String Serialize(Document document)
	{	
		Gson gsonParser= new Gson();
		String json = gsonParser.toJson(document);
		return json;
	}	
}
