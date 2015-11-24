package org.agilar.csd.solid.DIP.IoC;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.google.inject.Singleton;

@Singleton
public class DocumentStorageFactory implements StorageFactory {

	/* (non-Javadoc)
	 * @see org.agilar.csd.solid.DIP.IoC.DocumentStoareFactory#GetInputRetrieverForFileName(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see org.agilar.csd.solid.DIP.IoC.StorageFactory#GetInputRetrieverForFileName(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see org.agilar.csd.solid.DIP.IoC.DocumentStoareFactory#GetDocumentPersisterForFileName(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see org.agilar.csd.solid.DIP.IoC.StorageFactory#GetDocumentPersisterForFileName(java.lang.String)
	 */
	@Override
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