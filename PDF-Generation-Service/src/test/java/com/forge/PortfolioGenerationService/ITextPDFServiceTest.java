package com.forge.PortfolioGenerationService;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.forge.PDFGenerationService.PDFGenerationServiceApplication;
import com.forge.PDFGenerationService.models.AboutMe;
import com.forge.PDFGenerationService.models.AboutMeItem;
import com.forge.PDFGenerationService.models.Education;
import com.forge.PDFGenerationService.models.IndustryEquivalency;
import com.forge.PDFGenerationService.models.Portfolio;
import com.forge.PDFGenerationService.models.Project;
import com.forge.PDFGenerationService.models.ProjectResponsibilities;
import com.forge.PDFGenerationService.models.ProjectTechnologies;
import com.forge.PDFGenerationService.models.SkillMatrix;
import com.forge.PDFGenerationService.models.SkillMatrixItem;
import com.forge.PDFGenerationService.models.User;
import com.forge.PDFGenerationService.repository.PortfolioRepo;
import com.forge.PDFGenerationService.service.ITextPDFService;

@SpringBootTest(classes= {PDFGenerationServiceApplication.class, PortfolioRepo.class, ITextPDFService.class})
class ITextPDFServiceTest {

	@Autowired
	PortfolioRepo portR;
	@Autowired
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
	
	//check to ensure a valid object actually hits every bit of functionality
	@Test
	public void TestValidPortfolioPDF() {
		//setup a mock portfolio... ugh
		//set up the about me
		AboutMe about = new AboutMe();
		//create our user
		User user = new User();
		//set up our hashsets for underyling item lists
		Set<AboutMeItem> abi = new HashSet<AboutMeItem>();
		Set<Project> pj = new HashSet<Project>();
		Set<Education> ed = new HashSet<Education>();
		Set<SkillMatrix> sm = new HashSet<SkillMatrix>();
		Set<IndustryEquivalency> ie = new HashSet<IndustryEquivalency>();
		Set<ProjectResponsibilities> rps = new HashSet<ProjectResponsibilities>();
		Set<ProjectTechnologies> rns = new HashSet<ProjectTechnologies>();
		Set<SkillMatrixItem> smi = new HashSet<SkillMatrixItem>();
		//create our portfolio
		Portfolio port = new Portfolio(1,"User","pending",about,user,pj,ed,sm,ie);
		
		//set up user in portfolio
		port.setMyUser(new User(1,"test@unittest.com","unittest","unittest", "unittest",new HashSet<Portfolio>()));
		port.getMyUser().getPortfolios().add(port);
		
		//configure the about me in portfolio
		port.setAboutMe(new AboutMe(1, "unittest", port, abi));
		//add an item to the about me
		port.getAboutMe().getAboutMeItems().add(new AboutMeItem(1, "unittest", port.getAboutMe()));
		//create a project item for portfolio
		Project proj = new Project(1, "unittest", "unittest", port, rps, rns);
		//add item to project tech and project resp
		proj.getProjectResponsibilities().add(new ProjectResponsibilities(1, "unittest", proj));
		proj.getProjectTechnologies().add(new ProjectTechnologies(1,"unittest",proj));
		//add smi to sm
		SkillMatrix smbare = new SkillMatrix(1, "unittest", port, smi);
		smi.add(new SkillMatrixItem(1, "unittest", "unittest", smbare));
		//add skillmatrix to portfolio
		port.getSkillMatrix().add(smbare);
		//add project to portfolio
		port.getProjects().add(proj);
		//add industry equivalency
		port.getIndustryEquivalency().add(new IndustryEquivalency(1,12,"unittest",port));
		
		//add Education
		port.getEducation().add(new Education(1, "unittest", new Date(), "unittest", "unittest", "unittest", port));
		
		
		//test it out to make sure we didn't miss anything
		System.out.println(port.toString());
		
		Assertions.assertNotNull(pdfS.createITextPortfolioPDF(port));
	}
}
