package org.agilar.csd.solid.Example1.DIP.Manual;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CamelCaseJsonSerializer implements DocumentSerializer {

	@Override
	public String Serialize(Document document)
	{
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		return gson.toJson(document);
	}
	
}
 