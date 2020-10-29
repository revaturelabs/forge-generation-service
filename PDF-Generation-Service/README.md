
# PDF-Generation-Service

This service is used for dynamic PDF generation and storage of a portfolio to an Amazon S3 bucket.  The full list of technologies used in this project for user functionality:

  - Amazon AWS SDK API (used for S3 interaction)
  - iText 7 API (used for PDF generation)
  - Spring Boot
  - Spring Web
  - Spring Data
  - NetFlix OSS Eureka Client (Spring Cloud)
  - Project Lombok
  - Java 8
   
For unit testing, the following technologies are employed:
  - JUnit 5
  - Mockito
  - Rest Assured

Code coverage was performed with EclEMMA, a plugin that comes prepackaged with Eclipse J2EE version.  As of this writing, code coverage was 93.9% from this tool.
# How to consume the RESTful API in this service
There are only two endpoints that are exposed in this iteration of this service.  Both have a prefix of /pdf.
  - /pdf/getPDF/{username}/{id}
     * This endpoint will grab a generated PDF from the assigned S3 bucket by first searching the username, and then the id of their requested portfolio.  On successful retrieval, it will return back an array of bytes produces as application/pdf.
  - /pdf/storePDF/{id}
     *  This endpoint will first retrieve a portfolio with the id supplied in the path and convert it into a PDF with the iText 7 API.  After this conversion is done it is then stored as an array of bytes and converted to a file on local storage.  After this conversion occurs, it is then uploaded to the assigned S3 bucket in the format of Portfolio username/portfolio id.

### Internal API services
Behind the scenes of the endpoints are a couple points of interest to cover.  The two primarily important services here are ITextPDFService and S3FileService.
  - S3FileService
    * Responsbile for interactions with the assigned S3 Bucket.  Important to note is that the credentials are assumed to be supplied in the local machine's /home/usr/.aws/credentials file.  After that, there are three primary methods of upload, getFile, and delete.  There is one utility method of writeFile which converts an array of bytes into a File object.
  - ITextPDFService
    *  This service is responsible for consuming a Portfolio object and generating it into a PDF.  The primary entry point is getPortfolioPDF which retrieves a Portfolio and then sends it to createITextPortfolioPDF(portfolio).  createITextPortfolioPDF will conditionally check each part of a portfolio and add in sections if they are present or not.  After this conversion is done, it returns back an array of bytes, which is then returned by getPortfolioPDF.
	
### Important note about the PDF service
There are a few constraints in using the PDF generation service
  - In PDFController.java you will notice that there are endpoints that call s3S.getFile() and s3S.upload().  They contain a "/" or "" for the first parameter, this **must** be changed to your respective bucket name.
  - Similar issues with S3ServiceTest.java as above.
  - The AWS S3 upload and download service (S3FileService) makes the assumption that you have the credentials for AWS S3 in the local system.
    * For Windows, it should be located at C:\Users\(username)\.aws\credentials
	* For Linux, it should be located at ~/.aws/credentials

For future iterations it may be a good idea to configure S3FileService on line 25 (as of this writing) to instead grab credentials from environment variables.  You could even try to have it check for one and if it fails, have it try the other.
	
