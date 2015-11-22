package org.agilar.csd.solid.SRP;

import com.google.gson.Gson;

public class DocumentSerializer {

	public String Serialize(Document document)
	{	
		Gson gsonParser= new Gson();
		String json = gsonParser.toJson(document);
		return json;
	}	
}
