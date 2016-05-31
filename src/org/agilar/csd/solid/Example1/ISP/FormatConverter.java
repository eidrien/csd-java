package org.agilar.csd.solid.Example1.ISP;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class FormatConverter {

	InputParser inputParser = null;
	JsonDocumentSerializer documentSerializer = null;

	public FormatConverter() {
		inputParser = new JsonInputParser();
		documentSerializer = new JsonDocumentSerializer();

	}

	public boolean ConvertFormat(String sourceFileName, String targetFileName)
			throws IOException, ParserConfigurationException, SAXException, InvalidKeyException, URISyntaxException {

		boolean converted = false;
		File input = null;

		InputRetriever sourceDocumentStorage = GetDocumentRetrieverForFileName(sourceFileName);
		input = sourceDocumentStorage.GetData(sourceFileName);

		Document doc = inputParser.ParserInput(input);
		String serializedDoc = documentSerializer.Serialize(doc);

		DocumentPersister targetDocumentStorage = GetDocumentStorageForFileName(targetFileName);
		targetDocumentStorage.PersistDocument(serializedDoc, targetFileName);
		converted = true;
		return converted;

	}

	private DocumentStorage GetDocumentStorageForFileName(String fileName)
			throws InvalidKeyException, URISyntaxException {

		if (IsBlobstorageUrl(fileName))
			return new BlobDocumentStorage(Main.storageAccount, Main.storageKey);

		

		return new FileDocumentStorage();
	}

	private  InputRetriever GetDocumentRetrieverForFileName(String fileName)
			throws InvalidKeyException, URISyntaxException {

		if (IsBlobstorageUrl(fileName))
			return new BlobDocumentStorage(Main.storageAccount, Main.storageKey);

		if (fileName.startsWith("http"))
			return new HttpInputRetriever();

		return new FileDocumentStorage();
	}
	private boolean IsBlobstorageUrl(String str) {

		return str.startsWith(String.format("https://%s.blob.core.windows.net/", Main.storageAccount));
	}

}
