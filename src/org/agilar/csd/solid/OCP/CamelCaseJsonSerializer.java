package org.agilar.csd.solid.OCP;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CamelCaseJsonSerializer implements DocumentSerializer
{

	public String Serialize(Document document) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		return gson.toJson(document);
	}

}
