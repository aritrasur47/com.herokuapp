package com.herokuapp.theinternet.uploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;

public class UploadTests extends TestUtilities {
	@Test
	public void imageUploadTest() {
		log.info("Starting imageUploadTest");

		// Open File Upload Page
		FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
		fileUploaderPage.openPage();

		// Select Page
		String fileName = "logo.png";
		fileUploaderPage.selectFile(fileName);

		// Push Upload Button
		fileUploaderPage.pushUploadButton();

		// Get Uploaded Files
		String fileNames = fileUploaderPage.getUploadedFileNames();

		// Verify Selected files uploaded
		Assert.assertTrue(fileNames.contains(fileName),
				"Our file (" + fileName + ") is not one of the uploaded (" + fileName + ")");
	}

}
