package org.agilar.csd.solid.LSP;

import com.google.gson.Gson;


public class JsonDocumentSerializer implements DocumentSerializer
{

	@Override
	public String Serialize(Document document) {
		// TODO Auto-generated method stub
		Gson jsonFile = new Gson();
		return jsonFile.toJson(document);
	}

}



