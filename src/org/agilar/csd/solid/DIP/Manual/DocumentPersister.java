package org.agilar.csd.solid.DIP.Manual;

import java.io.IOException;

public interface DocumentPersister {
	 public  void PersistDocument(String serializedDocument, String targetFileName) throws IOException;
}
