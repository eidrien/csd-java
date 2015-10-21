package org.agilar.csd.solid.DIP.ServiceLocator;

import com.google.inject.AbstractModule;

public class FormatConverterModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(InputParser.class).to(JsonInputParser.class);
		bind(DocumentSerializer.class).to(CamelCaseJsonSerializer.class);
	}

}
