package org.agilar.csd.solid.DIP.IoC;

import com.google.gson.Gson;
import com.google.inject.Singleton;

@Singleton
public class JsonDocumentSerializer implements DocumentSerializer {

	public String Serialize(Document document)
	{	
		Gson gsonParser= new Gson();
		String json = gsonParser.toJson(document);
		return json;
	}	
}
