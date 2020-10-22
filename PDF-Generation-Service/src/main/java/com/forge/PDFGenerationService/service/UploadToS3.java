package com.forge.PDFGenerationService.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class UploadToS3 {

	private static ProfileCredentialsProvider credentials = new ProfileCredentialsProvider();
	static String bucketName = "catcssp2imgbucket";
	static String fileName = "portfolio.pdf";
	static String SUFFIX = "/";
	static String username = "testuser";
	static int portfolioId = 2;
	
	
	public static void main(String[] args) {
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials((credentials))
				  .withRegion(Regions.US_EAST_2)
				  .build();
		
//		upload(bucketName,username,portfolioId);
		
		try {
			getFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//upload(bucketName, fileName);
		
	}
	
	public static void upload(String bucketName, String username,int portfolioid) {
		AmazonS3  s3client = new AmazonS3Client(credentials);
		
		s3client.putObject(new PutObjectRequest(bucketName,username+SUFFIX+portfolioid,new File("d://"+fileName)));
		s3client.setObjectAcl(bucketName, username+SUFFIX+portfolioid, CannedAccessControlList.PublicRead);
		
	}
	
	
	// Checks if the file is actually in the s3
	public static byte[] getFile() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials((credentials))
				  .withRegion(Regions.US_EAST_2)
				  .build();
		
		String id = "" + portfolioId;
		
		
		S3Object s3object = s3client.getObject(bucketName+SUFFIX+username, id);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
//		displayTextInputStream(inputStream);
		while(inputStream.read() != -1)
			out.write(inputStream.read());
//		s3object.
		System.out.println("Length of array: " + out.toByteArray().length);
		for(int i=0;i<out.toByteArray().length;i++) {
			System.out.print(out.toByteArray()[i]);
		}
		return out.toByteArray();
	}
	
    private static void displayTextInputStream(InputStream input) throws IOException {
        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println();
    }
	
}
