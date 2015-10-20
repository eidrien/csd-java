package org.agilar.csd.solid.OCP;

import java.io.File;


public abstract class DocumentStorage {

    public abstract File GetData(String fileName);
    public abstract void PersistDocument(String serializedDocument, String targetFileName);
}




