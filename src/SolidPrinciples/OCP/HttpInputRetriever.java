package SolidPrinciples.OCP;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpInputRetriever extends DocumentStorage{

	@Override
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

	@Override
	public void PersistDocument(String serializedDocument, String targetFileName) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

}
