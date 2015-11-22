package org.agilar.csd.solid.ISP;

import java.io.IOException;

public interface DocumentPersister {
	 public  void PersistDocument(String serializedDocument, String targetFileName) throws IOException;
}
