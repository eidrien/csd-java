package org.agilar.csd.solid.DIP.ServiceLocator;

import java.io.File;


public abstract class DocumentStorage implements InputRetriever , DocumentPersister {

    public abstract File GetData(String fileName);
    public abstract void PersistDocument(String serializedDocument, String targetFileName);
}




