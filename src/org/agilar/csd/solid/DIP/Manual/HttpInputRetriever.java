package org.agilar.csd.solid.DIP.Manual;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpInputRetriever implements InputRetriever {

	public File GetData(String fileName) {
		if (!fileName.startsWith("http"))
        {
          
		    try {
				throw new InvalidTargetException();
			} catch (InvalidTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }
		URI uri = null;
		try {
			uri = new URI(fileName);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        return new File(uri);
	}

	

}