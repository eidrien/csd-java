package org.agilar.csd.solid.OCP;

import java.io.File;
import java.io.IOException;

public abstract class DocumentStorage {

	public abstract File GetData(String fileName);

	public abstract void PersistDocument(String serializedDocument, String targetFileName) throws IOException ;



}