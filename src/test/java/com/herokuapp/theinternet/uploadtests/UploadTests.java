package com.herokuapp.theinternet.uploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;

public class UploadTests extends TestUtilities {
	@Test(dataProvider = "files")
	public void fileUploadTest(int no, String fileName) {
		log.info("Starting fileUploadTest #" + no + " for " + fileName);

		// Open File Upload Page
		FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
		fileUploaderPage.openPage();

		// Select Page
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
