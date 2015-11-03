package org.agilar.csd.SRP.ExampleClass;

public class Main {

	public static void main(String[] args) {
		try {
			
			String current = new java.io.File(".").getCanonicalPath();
			String inputFileName = current + "/Input Documents/Document1.xml";
			String outputFileName = current + "/Output Documents/Document1.json";
            
			FormatConverter formatConverter = new FormatConverter();
			boolean formateado = formatConverter.ConvertFormat(inputFileName, outputFileName);
			if (formateado)
				System.out.println("OK");
			else
				System.out.println("KO");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	
	
	

}
