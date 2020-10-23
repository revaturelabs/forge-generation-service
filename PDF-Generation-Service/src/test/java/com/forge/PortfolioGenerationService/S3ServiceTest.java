package com.forge.PortfolioGenerationService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.forge.PDFGenerationService.service.S3FileService;

public class S3ServiceTest {

	private S3FileService s3Serv = new S3FileService();
	private byte[] content = {'I', ' ', 'a','m',' ','f','o','r',' ','u','n','i','t',' ','t','e','s','t','i','n','g',' ','o','n','l','y','.'};
	private String bucket="catcssp2imgbucket";
	private String username="unittestuser";
	private int id=1;
	
	@Test
	@Order(1)
	public void attemptToDeleteInvalidFile() {
		Assertions.assertEquals("Could not delete file.", s3Serv.delete("", "", 0));
	}

	@Test
	@Order(2)
	public void attemptToUploadBadlyNamedFile() {
		Assertions.assertEquals("Failed to upload file.", s3Serv.upload("", "", id, content));
	}

	@Test
	@Order(3)
	public void uploadFile() {
		Assertions.assertEquals("Successful upload.", s3Serv.upload(bucket, username, id, content));
	}
	
	@Test
	@Order(4)
	public void notNullFile() {
		Assertions.assertNotNull(s3Serv.getFile(bucket, username, id));
	}
	
	@Test
	@Order(5)
	public void deleteValidFile() {
		Assertions.assertEquals("File deleted.", s3Serv.delete(bucket, username, id));
	}
	
}
