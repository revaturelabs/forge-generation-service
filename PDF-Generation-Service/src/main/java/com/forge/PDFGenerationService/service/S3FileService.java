package com.forge.PDFGenerationService.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

@Service
public class S3FileService {

	//we assume that s3 credentials are stored in s3.
	private ProfileCredentialsProvider credentials = new ProfileCredentialsProvider();

	//helper method for upload.  we take in a byte array (our raw file data) and then spit out a reference to the full file.
	private File writeFile(byte[] input) {
		File file = new File("file");
		try {
			OutputStream out = new FileOutputStream(file);
			out.write(input);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	//we just use this to upload a file to s3.  we pass in the bucket name, username, and the portfolio id then s3
	//will take care of the rest.  
	//it is assumed that the credentials are stored on the local machine in /Users/[username]/.aws/credentials
	public void upload(String bucketName, String username, int portfolioid, byte[] content) {
		AmazonS3 s3client = new AmazonS3Client(credentials);

		File f = this.writeFile(content);
		
		//write our object to our predefined output bucket
		s3client.putObject(new PutObjectRequest(bucketName, username + "/" + portfolioid, f));
		s3client.setObjectAcl(bucketName, username + "/" + portfolioid, CannedAccessControlList.PublicRead);

	}

	// Checks if the file is actually in the s3
	public byte[] getFile(String bucketName, String username, int portfolioId) {
		byte[] out=null;
		AmazonS3 s3client = AmazonS3ClientBuilder.standard().withCredentials((credentials))
				.withRegion(Regions.US_EAST_2).build();
		
		String id = "" + portfolioId;

		//grab the object on the s3 instance
		S3Object s3object = s3client.getObject(bucketName + "/" + username, id);
		
		try {
			//look! we're converting it to bytes!
			out = IOUtils.toByteArray(s3object.getObjectContent());
		} catch (IOException e) {
			e.printStackTrace();
		}

		//give the consumer a pile o bytes
		return out;
	}


}
