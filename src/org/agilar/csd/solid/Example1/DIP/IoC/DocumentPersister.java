package org.agilar.csd.solid.Example1.DIP.IoC;

import java.io.IOException;

public interface DocumentPersister {
	 public  void PersistDocument(String serializedDocument, String targetFileName) throws IOException;
}
