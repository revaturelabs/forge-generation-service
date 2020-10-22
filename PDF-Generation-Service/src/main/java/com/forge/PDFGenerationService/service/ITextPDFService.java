package com.forge.PDFGenerationService.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

@Service
public class ITextPDFService {
	
	@Autowired
	private PortfolioRepo portR;
	
	public ITextPDFService(PortfolioRepo portR) {
		this.portR=portR;
	}

	public byte[] getPortfolioPDF(int id) {
		Portfolio port = portR.findById(id);
		return this.createITextPortfolioPDF(port);
	}
	
	// common functionality - adds a named header to categories
	public void addNamedHeader(Document document, PdfWriter writer, Canvas canvas, String headerName) {
		PdfFont largeBold=null;
		try {
			largeBold = PdfFontFactory.createFont(StandardFonts.HELVETICA);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Paragraph header = new Paragraph();
		header.setFontSize(20);
		header.setFont(largeBold);
		header.add(new Paragraph(headerName));
		document.add(header);
	}


	private void addProjectResponsibilitiesItem(Document document, PdfWriter writer, Canvas canvas, ProjectResponsibilities resp) {
		PdfFont small=null;
		try {
			small = PdfFontFactory.createFont(StandardFonts.HELVETICA	);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Paragraph matrixP = new Paragraph();

		matrixP.setBackgroundColor(new DeviceRgb(115,165,194));

		matrixP.add(new Paragraph(resp.getContent()).setFont(small).setFontSize(8));


		
		document.add(matrixP);
	}


	private void addProjectItem(Document document, PdfWriter writer, Canvas canvas, Project project) {
		PdfFont small=null;
		try {
			small = PdfFontFactory.createFont(StandardFonts.HELVETICA	);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Paragraph projectP = new Paragraph();

		projectP.setBackgroundColor(new DeviceRgb(115,165,194));

		projectP.add(new Paragraph(project.getName()).setFont(small).setFontSize(18));
		projectP.add(new Text("\n").setFontSize(4).setFont(small));
		projectP.add(new Text(project.getDescription()).setFontSize(12).setFont(small));
		projectP.add(new Text("\n").setFontSize(4));

		
		document.add(projectP);
		projectP = new Paragraph();
		projectP.add("Technologies Used: ");
		int index = 0;
		// add each education item to the list with addEducationItem
		for (ProjectTechnologies tech: project.getProjectTechnologies()) {
			index++;
			projectP.add(tech.getName());
//			project.getProjectTechnologies().remove(tech);
			if(index < project.getProjectTechnologies().size()) {
				projectP.add(", ");
			}
		}

		projectP.add("\n");
		projectP.add("Roles and Responsibilities");
		
		document.add(projectP);
		// add each education item to the list with addEducationItem
		for (int i = 0; i < project.getProjectResponsibilities().size(); i++) {
			this.addProjectResponsibilitiesItem(document, writer, canvas, project.getProjectResponsibilities().iterator().next());
		}

	}

	private void addProjects(Document document, PdfWriter writer, Canvas canvas, Set<Project> project) {
		// add each education item to the list with addEducationItem
		Paragraph projects = new Paragraph();

		this.addNamedHeader(document, writer, canvas, "Projects");
		
		// add each education item to the list with addEducationItem

		document.add(projects);

		for (Project projectsList: project) {
			this.addProjectItem(document, writer, canvas, projectsList);
		}
	}

	private void addSkillSubItem(Document document, PdfWriter writer, Canvas canvas, SkillMatrixItem matrixItem) {
		PdfFont small=null;
		try {
			small = PdfFontFactory.createFont(StandardFonts.HELVETICA	);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Paragraph matrixP = new Paragraph();

		matrixP.setBackgroundColor(new DeviceRgb(115,165,194));

		matrixP.add(new Paragraph(matrixItem.getName()).setFont(small).setFontSize(12));
		matrixP.add(new Text(matrixItem.getExperience() + " Months"));
		matrixP.add(new Text("\n").setFontSize(12).setFont(small));

		
		document.add(matrixP);
	}

	private void addSkillItem(Document document, PdfWriter writer, Canvas canvas, SkillMatrix matrix) {
		PdfFont small=null;
		try {
			small = PdfFontFactory.createFont(StandardFonts.HELVETICA	);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Paragraph matrixP = new Paragraph();

		matrixP.setBackgroundColor(new DeviceRgb(115,165,194));

		matrixP.add(new Paragraph(matrix.getTitle()).setFont(small).setFontSize(18));
		matrixP.add(new Text("\t").setFontSize(12).setFont(small));

		// add each education item to the list with addEducationItem
		document.add(matrixP);
		for (SkillMatrixItem matrixI: matrix.getSkillMatrixItem()) {
			this.addSkillSubItem(document, writer, canvas, matrixI);
		}
	}

	private void addSkills(Document document, PdfWriter writer, Canvas canvas, Set<SkillMatrix> matrixList) {
		// color of blue is 115,165,194
		// color of yellow is 253,181,21
		// color of light gray is 185, 185, 186
		// color of dark gray is 72,76,86
		// color of orange is 242, 105, 38
		// white is 255,255,255. HUH!
		
		Paragraph skills = new Paragraph();

		this.addNamedHeader(document, writer, canvas, "Skill Matrix");
		
		// add each education item to the list with addEducationItem

		document.add(skills);
		for (SkillMatrix matrix: matrixList) {
			this.addSkillItem(document, writer, canvas, matrix);
		}


	}
	
	private void addIndustryEquivalencyItem(Document document, PdfWriter writer, Canvas canvas, IndustryEquivalency equiv) {
		PdfFont small=null;
		try {
			small = PdfFontFactory.createFont(StandardFonts.HELVETICA	);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		Paragraph equivP = new Paragraph();
		equivP.setBackgroundColor(new DeviceRgb(115,165,194));

		equivP.add(new Paragraph(equiv.getTechnology()).setFont(small).setFontSize(18));
		equivP.add(new Text("\n").setFontSize(12).setFont(small));
		equivP.add(new Paragraph("Experience Equivalency: " + equiv.getMonths() + " Months"));


		document.add(equivP);
	}

	private void addIndustryEquivalency(Document document, PdfWriter writer, Canvas canvas, Set<IndustryEquivalency> equivs) {
		// color of blue is 115,165,194
		// color of yellow is 253,181,21
		// color of light gray is 185, 185, 186
		// color of dark gray is 72,76,86
		// color of orange is 242, 105, 38
		// white is 255,255,255. HUH!
		Paragraph about = new Paragraph();
		this.addNamedHeader(document, writer, canvas, "Industry Equivalency");

		document.add(about);
		
		// add each education item to the list with addEducationItem
		for(IndustryEquivalency equiv : equivs) {
			this.addIndustryEquivalencyItem(document, writer, canvas, equiv);
		}
	}

	private void addEducationItem(Document document, PdfWriter writer, Canvas canvas, Education education) {
		PdfFont small=null;
		try {
			small = PdfFontFactory.createFont(StandardFonts.HELVETICA	);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Paragraph educationItem = new Paragraph();
		canvas.setBackgroundColor(new DeviceRgb(115,165,194));

		educationItem.add(new Paragraph(education.getUniversity()).setFont(small).setFontSize(18));
		educationItem.add(new Text("\n").setFontSize(12).setFont(small));
		educationItem.add(new Paragraph("Major: " + education.getMajor() + "\t Minor: " + education.getMinor()));
		educationItem.add(new Text("\n"));
		educationItem.add(new Paragraph("Date of Graduation: " + education.getGraduation().toLocaleString()));
		document.add(educationItem);
	}

	private void addEducation(Document document, PdfWriter writer, Canvas canvas, Set<Education> education) {
		// color of blue is 115,165,194
		// color of yellow is 253,181,21
		// color of light gray is 185, 185, 186
		// color of dark gray is 72,76,86
		// color of orange is 242, 105, 38
		// white is 255,255,255. HUH!
		Paragraph about = new Paragraph();
		this.addNamedHeader(document, writer, canvas, "Education");

		document.add(about);
		// add each education item to the list with addEducationItem
		for(Education edu : education) {
			this.addEducationItem(document, writer, canvas, edu);
		}
	
	}

	private void addAboutMeItem(Document document, PdfWriter writer, Paragraph about, AboutMeItem aboutMeItem) {
		PdfFont small=null;
		try {
			small = PdfFontFactory.createFont(StandardFonts.HELVETICA	);
		} catch (IOException e) {
			e.printStackTrace();
		}

		document.setBackgroundColor(new DeviceRgb(115,165,194));
		about.add(new Paragraph(aboutMeItem.getContent()).setFont(small).setFontSize(12));

	}

	private void addAboutMe(Document document, PdfWriter writer, Canvas canvas, AboutMe aboutMe) {
		// color of blue is 115,165,194
		// color of yellow is 253,181,21
		// color of light gray is 185, 185, 186
		// color of dark gray is 72,76,86
		// color of orange is 242, 105, 38
		// white is 255,255,255. HUH!
		
		Paragraph about = new Paragraph();
		this.addNamedHeader(document, writer, canvas, "About Me");
		about.setBackgroundColor(new DeviceRgb(115,165,194));
		about.add(new Text(aboutMe.getDescription()).setFontSize(12));
		for(AboutMeItem ami : aboutMe.getAboutMeItems()) {
			this.addAboutMeItem(document, writer, about, ami);
		}
		document.add(about);
		// add each of the about me items into the section here

	}

	private void addHeader(Document document, PdfWriter writer, Canvas canvas, User user) {
		// color of blue is 115,165,194
		// color of yellow is 253,181,21
		// color of light gray is 185, 185, 186
		// color of dark gray is 72,76,86
		// color of orange is 242, 105, 38
		// white is 255,255,255. HUH!
		
		PdfFont small=null;
		try {
			small = PdfFontFactory.createFont(StandardFonts.HELVETICA	);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Paragraph header = new Paragraph();
		this.addNamedHeader(document, writer, canvas, user.getFirstName() + " " + user.getLastName());
		header.add(new Text("Software Engineer\n").setFontSize(12).setFont(small));

		header.add(new Paragraph("Email: ").setFontSize(18).setFont(small));
				header.add (new Paragraph(user.getEmail() ).setFontSize(12).setFont(small));
		document.add(header);
		SolidLine line = new SolidLine(1f);
		line.setColor(new DeviceRgb(242,105,38));
		LineSeparator ls = new LineSeparator(line);
		ls.setWidth(565);
		document.add(ls);
	}

	// we use this to generate metadata for our PDFs
	private void addMetaData(Document document, String username, String firstName, int id) {
		/*
		 * document.("Portfolio " + id + " for " + username);
		 * document.addSubject("Portfolio");
		 * document.addKeywords("PDF, portfolio, hiring, recruitment, technology");
		 * document.addAuthor(username + " " + firstName);
		 * document.addCreator("ITextPDFService generated for " + firstName );
		 */
	}

	public byte[] createITextPortfolioPDF(Portfolio port) {

		byte[] byteArr = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(out);
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);

		PdfPage page = pdf.addNewPage();
		PdfCanvas pdfCanvas = new PdfCanvas(page);
		document.setLeftMargin(13.5f);
		document.setTopMargin(13.5f);
		document.setRightMargin(13.5f);
		document.setBottomMargin(13.5f);

		
		
		Canvas canvas = new Canvas(pdfCanvas, pdf, new Rectangle(document.getLeftMargin(),document.getTopMargin(),550,850));


		this.addMetaData(document, port.getMyUser().getEmail(), port.getMyUser().getFirstName(), port.getId());
		this.addHeader(document, writer, canvas, port.getMyUser());
		if(port.getAboutMe() != null && !port.getIndustryEquivalency().isEmpty())
			this.addAboutMe(document, writer, canvas, port.getAboutMe());
		if(port.getEducation() != null && !port.getEducation().isEmpty())
			this.addEducation(document, writer, canvas, port.getEducation());
		if(port.getIndustryEquivalency() != null && !port.getIndustryEquivalency().isEmpty())
			this.addIndustryEquivalency(document, writer, canvas, port.getIndustryEquivalency());
		if(port.getSkillMatrix() != null && !port.getSkillMatrix().isEmpty())
			this.addSkills(document, writer, canvas, port.getSkillMatrix());
		if(port.getProjects() != null && !port.getProjects().isEmpty())
			this.addProjects(document, writer, canvas, port.getProjects());

		
		
		canvas.close();
		document.close();
		byteArr = out.toByteArray();
		return byteArr;
	}

}
