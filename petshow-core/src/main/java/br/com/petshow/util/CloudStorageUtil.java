package br.com.petshow.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.StorageScopes;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.common.collect.ImmutableList;

public class CloudStorageUtil {

	private Storage client;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private final String applicationName;
	private static HttpTransport httpTransport;
	public CloudStorageUtil(String applicationName) {
		super();
		this.applicationName = applicationName;
	}
	
	//Connects to Google API
	public void connect(String accountId, File p12File) throws GeneralSecurityException, IOException {
		
		httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		Credential credential = authorize(accountId, p12File);
		client = new Storage.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName(applicationName)
				.build();
		
	}
	
	private Credential authorize(String accountId, File p12File) throws GeneralSecurityException, IOException {
		Set<String> scopes = new HashSet<>();
		scopes.add(StorageScopes.DEVSTORAGE_FULL_CONTROL);
		scopes.add(StorageScopes.DEVSTORAGE_READ_ONLY);
		scopes.add(StorageScopes.DEVSTORAGE_READ_WRITE);
		
		JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		GoogleCredential credential = new GoogleCredential.Builder()
				.setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY)
				.setServiceAccountId(accountId)
				.setServiceAccountPrivateKeyFromP12File(p12File)
				.setServiceAccountScopes(scopes)
				.build();
		return credential;
	}
	
	public Bucket getBucket(String bucketName) throws IOException {
		Storage.Buckets.Get getBucket = client.buckets().get(bucketName);
		getBucket.setProjection("full");
		return getBucket.execute();
	}
	
	public List<StorageObject> getBucketFiles(Bucket bucket) throws IOException {
		Storage.Objects.List listObjects = client.objects().list(bucket.getName());
		com.google.api.services.storage.model.Objects objects;
		ArrayList<StorageObject> all = new ArrayList<>();
		do {
			objects = listObjects.execute();
			List<StorageObject> items = objects.getItems();
			if(items == null) {
				//Empty
				return all;
			}
		} while (null != objects.getNextPageToken());
		return all;
	}
	
	public StorageObject upload(String bucketName, File file, String contentType, String projectId) throws IOException {
		if(client == null) {
			throw new IOException("Cloud Storage API cannot connect");
		}
		if(file == null || !file.exists()) {
			throw new FileNotFoundException("File not found!");
		}
		String fileName = file.getName();
		InputStream inputStream = new FileInputStream(file);
		long byteCount = file.length();
		InputStreamContent mediaContent = new InputStreamContent(contentType, inputStream);
		mediaContent.setLength(byteCount);
		ImmutableList<ObjectAccessControl> acl = ImmutableList.of(
				
		);
		return null;
		
	}

}
