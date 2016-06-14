package org.agilar.csd.solid.Example1.SRP;

public class Main {

    public static void main(String[] args) {
        try {
            String current    = new java.io.File( "." ).getCanonicalPath();
            String inputFile  = current + "\\Input Documents\\Document1.xml";
            String outputFile = current + "\\Output Documents\\Document1.json";
            boolean converted = false;
            FormatConverter converter = new FormatConverter();
            converted = converter.ConvertFormat(inputFile, outputFile);
            if (!converted)
            	System.out.println("KO");
            else
            	System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	

	


}
