package org.agilar.csd.solid.DIP.IoC;

public interface StorageFactory {

	/* (non-Javadoc)
	 * @see org.agilar.csd.solid.DIP.IoC.DocumentStoareFactory#GetInputRetrieverForFileName(java.lang.String)
	 */
	InputRetriever GetInputRetrieverForFileName(String fileName);

	/* (non-Javadoc)
	 * @see org.agilar.csd.solid.DIP.IoC.DocumentStoareFactory#GetDocumentPersisterForFileName(java.lang.String)
	 */
	DocumentPersister GetDocumentPersisterForFileName(String fileName);

}