package org.agilar.csd.solid.LSP;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

//Include the following imports to use blob APIs.
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.sun.jndi.toolkit.url.Uri;



public class BlobDocumentStorage extends DocumentStorage
{
	
	 CloudBlobClient blobClient ;
	
    public BlobDocumentStorage(String storageAccount, String storageKey) throws InvalidKeyException, URISyntaxException
    {
    	String storageConnectionString = String.format("DefaultEndpointsProtocol=http;AccountName=%s;AccountKey=%s" , storageAccount,storageKey);
    	CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
    	blobClient = account.createCloudBlobClient();

    }
    
    @Override
    public File GetData(String fileName)
    {
      
    	if (!fileName.startsWith(blobClient.getStorageUri().toString()))
        {
            try {
				throw new InvalidTargetObjectTypeException();
			} catch (InvalidTargetObjectTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
    public void PersistDocument(String serializedDocument, String targetFileName)
    {
    
    	try
    	{
    	  
           Uri uri = new Uri (targetFileName);
           String containerName =  uri.getPath().substring(1,uri.getPath().indexOf("/",1)-1);
    	        	
    	    CloudBlobContainer container = blobClient.getContainerReference(containerName);
    	    container.createIfNotExists();
    	    
    	    BlobContainerPermissions containerPermissions = new BlobContainerPermissions();

    	    // Include public access in the permissions object.
    	    containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);

    	    // Set the permissions on the container.
    	    container.uploadPermissions(containerPermissions);
    	  

    	    // Create or overwrite the "myimage.jpg" blob with contents from a local file.
    	    CloudBlockBlob blob = container.getBlockBlobReference(targetFileName.replace(blobClient.getStorageUri() + containerName + "/", ""));
    	     blob.uploadText(serializedDocument);
    	}
    	catch (Exception e)
    	{
    	    // Output the stack trace.
    	    e.printStackTrace();
    	}
    	
    	/* if (!targetFileName.StartsWith(_blobClient.BaseUri.ToString()))
        {
            throw new InvalidTargetException();
        }

        var uri = new Uri(targetFileName);
        var containerName = uri.AbsolutePath.Substring(1, uri.AbsolutePath.IndexOf('/', 1) - 1);
        var container = _blobClient.GetContainerReference(containerName);
        container.CreateIfNotExists(BlobContainerPublicAccessType.Container);
        var blob = container.GetBlockBlobReference(targetFileName.Replace(_blobClient.BaseUri + containerName + "/", ""));
        blob.UploadText(serializedDocument);*/
    }
	
	
	


	
	
}