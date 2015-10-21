package org.agilar.csd.solid.DIP.ServiceLocator;

public interface DocumentPersister {
    public  void PersistDocument(String serializedDocument, String targetFileName);

}
