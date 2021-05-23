package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/upload";

	private By choseFileFieldLocator = By.id("file-upload");
	private By uploadButtonLocator = By.id("file-submit");
	private By uploadFilesLocator = By.id("uploaded-files");

	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// Open FileUploaderPage with it's URL
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	// Push upload button
	public void pushUploadButton() {
		log.info("Clicking on Upload Button");
		click(uploadButtonLocator);
	}

	public void selectFile(String fileName) {
		log.info("Selecting '" + fileName + "' file from Files folder.");

		// Selecting file
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, choseFileFieldLocator);
		log.info("File selected!");
	}

	// Get names of uploaded files
	public String getUploadedFileNames() {
		String names = find(uploadFilesLocator).getText();
		log.info("Uploaded files: " + names);
		return names;
	}
}
