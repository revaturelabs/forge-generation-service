package com.forge.PortfolioGenerationService;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class PDFControllerTest {

	@Test
	public void testGetPDF() {
		given().get("some url with the pdf/username/portfolioId").then().statusCode(200);
	}
	
}
