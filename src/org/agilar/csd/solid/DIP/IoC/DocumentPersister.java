package org.agilar.csd.solid.DIP.IoC;

import java.io.IOException;

public interface DocumentPersister {
	 public  void PersistDocument(String serializedDocument, String targetFileName) throws IOException;
}
