package com.forge.PortfolioGenerationService;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.forge.PDFGenerationService.controller.PDFController;
import com.forge.PDFGenerationService.models.Portfolio;
import com.forge.PDFGenerationService.service.ITextPDFService;
import com.forge.PDFGenerationService.service.PortfolioService;
import com.forge.PDFGenerationService.service.S3FileService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ITextPDFService.class,PortfolioService.class,S3FileService.class, PDFController.class})
public class PDFControllerTest {
	
	@MockBean 
	private ITextPDFService iPortS;
	
	@MockBean
	private PortfolioService portS;
	
	@MockBean
	private S3FileService s3S;
	
	@Autowired
	private PDFController pdfC;
	
	// URL: https://catcssp2imgbucket.s3.us-east-2.amazonaws.com/pdf/getPDF/{username}/{id}
	@Test
	public void testGetPDF() {
		byte[] expected = s3S.getFile("catcssp2imgbucket", "cmoore@email.com", 2);
		when(s3S.getFile("catcssp2imgbucket", "cmoore@email.com", 2)).thenReturn(expected);
		Assertions.assertEquals(expected,pdfC.getPDF("cmoore@email.com", 2));
	}
	
	
	// URL: https://catcssp2imgbucket.s3.us-east-2.amazonaws.com/pdf/storePDF/{id}
	@Test
	public void testStorePDF() {
		Portfolio expected = new Portfolio(16, "Name1", "Pending", null, null, null, null, null, null);
		pdfC.storePDF(expected.getId());
		when(s3S.upload("catcssp2imgbucket", expected.getMyUser().getEmail(), expected.getId(), iPortS.createITextPortfolioPDF(expected))).thenReturn("Successful upload.");	
		//verify(s3s, times(1)).upload
	}
	
}
