package org.agilar.csd.solid.DIP.Manual;

import java.io.File;
import java.io.IOException;

public abstract class DocumentStorage implements InputRetriever , DocumentPersister {

	public abstract File GetData(String fileName);

	public abstract void PersistDocument(String serializedDocument, String targetFileName) throws IOException ;



}