package org.agilar.csd.solid.DIP.IoC;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;


import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

public class BlobDocumentStorage extends DocumentStorage {

	CloudBlobClient blobClient;

	public BlobDocumentStorage(String storageAccount, String storageKey)
			throws InvalidKeyException, URISyntaxException {
		String storageConnectionString = String.format("DefaultEndpointsProtocol=http;AccountName=%s;AccountKey=%s",
				storageAccount, storageKey);
		CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
		blobClient = account.createCloudBlobClient();

	}

	@Override
	public File GetData(String fileName) {

		if (!fileName.startsWith(blobClient.getStorageUri().toString())) {

			throw new InvalidTargetException();

		}
		URI uri = null;
		try {
			uri = new URI(fileName);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new File(uri);
	}

	@Override
	public void PersistDocument(String serializedDocument, String targetFileName) {

		try {

			URI uri = new URI(targetFileName);
			String containerName = uri.getPath().substring(1, uri.getPath().indexOf("/", 1) - 1);

			CloudBlobContainer container = blobClient.getContainerReference(containerName);
			container.createIfNotExists();

			BlobContainerPermissions containerPermissions = new BlobContainerPermissions();

			// Include public access in the permissions object.
			containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);

			// Set the permissions on the container.
			container.uploadPermissions(containerPermissions);

			// Create or overwrite the "myimage.jpg" blob with contents from a
			// local file.
			CloudBlockBlob blob = container.getBlockBlobReference(
					targetFileName.replace(blobClient.getStorageUri() + containerName + "/", ""));
			blob.uploadText(serializedDocument);
		} catch (Exception e) {
			// Output the stack trace.
			e.printStackTrace();
		}

	}
	
	

}
