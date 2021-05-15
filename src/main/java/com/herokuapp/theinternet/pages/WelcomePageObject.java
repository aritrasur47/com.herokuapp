package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String pageURL = "https://the-internet.herokuapp.com/";
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// Open WelcomePage with its URL
	public void openPage() {
		log.info("Opening page : " + pageURL);
		openURL(pageURL);
		log.info("---- Page opened ----");
	}

	// Open LoginPage by clicking on Form Authentication Link
	public LoginPageObject clickFormAuthentucationLink() {
		log.info("Clicking Form Authentication Link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPageObject(driver, log);
	}
}
