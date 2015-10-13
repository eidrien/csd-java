package SolidPrinciples.OCP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public abstract class DocumentStorage {

    public abstract File GetData(String fileName);
    public abstract void PersistDocument(String serializedDocument, String targetFileName);
}




