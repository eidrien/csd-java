package org.agilar.csd.solid.Example1.DIP.IoC;

public interface StorageFactory {

	/* (non-Javadoc)
	 * @see org.agilar.csd.solid.Example1.DIP.IoC.DocumentStoareFactory#GetInputRetrieverForFileName(java.lang.String)
	 */
	InputRetriever GetInputRetrieverForFileName(String fileName);

	/* (non-Javadoc)
	 * @see org.agilar.csd.solid.Example1.DIP.IoC.DocumentStoareFactory#GetDocumentPersisterForFileName(java.lang.String)
	 */
	DocumentPersister GetDocumentPersisterForFileName(String fileName);

}