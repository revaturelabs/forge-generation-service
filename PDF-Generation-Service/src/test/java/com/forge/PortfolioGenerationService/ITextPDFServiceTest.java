package com.forge.PortfolioGenerationService;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.forge.PDFGenerationService.models.AboutMe;
import com.forge.PDFGenerationService.models.Education;
import com.forge.PDFGenerationService.models.IndustryEquivalency;
import com.forge.PDFGenerationService.models.Portfolio;
import com.forge.PDFGenerationService.models.Project;
import com.forge.PDFGenerationService.models.SkillMatrix;
import com.forge.PDFGenerationService.models.User;
import com.forge.PDFGenerationService.repository.PortfolioRepo;
import com.forge.PDFGenerationService.service.ITextPDFService;

class ITextPDFServiceTest {

	PortfolioRepo portR;
	ITextPDFService pdfS;
	// Checks whether a byte array is returned by displaying an id
	@Test
	public void testgetPortfolioPDF() {
		int id = 0;
		byte[] expected = null;
		Assertions.assertArrayEquals(expected, pdfS.getPortfolioPDF(id));
		
	}
	
	
	//Checks whether a PDF is produced with a Portfolio with a noArgs constructor
	@Test
	public void testCreatePortfolioPDFNoArgs() {
		Portfolio port = new Portfolio();
		pdfS.createITextPortfolioPDF(port);
		byte[] expected = null;
		Assertions.assertArrayEquals(expected,pdfS.createITextPortfolioPDF(port));	
	}
	
	//Checks whether a PDF is produced with a Portfolio with AllArgs constructor
	@Test
	public void TestCreatePortfolioPDFAllArgs() {
		AboutMe about = null;
		User user = null;
		Set<Project> pj = null;
		Set<Education> ed = null;
		Set<SkillMatrix> sm = null;
		Set<IndustryEquivalency> ie = null;
		Portfolio port = new Portfolio(1,"User","pending",about,user,pj,ed,sm,ie);
		byte[] expected = null;
		Assertions.assertArrayEquals(expected, pdfS.createITextPortfolioPDF(port));
	}
	
	
}
