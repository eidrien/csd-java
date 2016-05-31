package org.agilar.csd.solid.Example1.DIP.Manual;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

public class DocumentStorageFactory {

	public  InputRetriever GetInputRetrieverForFileName(String fileName) {

		if (Utils.IsBlobstorageUrl(fileName))
			try {
				return new BlobDocumentStorage(Utils.storageAccount, Utils.storageKey);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (fileName.startsWith("http"))
			return new HttpInputRetriever();

		return new FileDocumentStorage();
	}

	public  DocumentPersister GetDocumentPersisterForFileName(String fileName) {
		if (Utils.IsBlobstorageUrl(fileName))
			try {
				return new BlobDocumentStorage(Utils.storageAccount, Utils.storageKey);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return new FileDocumentStorage();
	}
}
