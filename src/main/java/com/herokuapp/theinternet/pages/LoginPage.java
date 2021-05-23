package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

	private By usernameLocator = By.id("username");
	private By passwordLocator = By.id("password");
	private By loginButtonLocator = By.tagName("button");
	private By errorMessageLocator = By.id("flash");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// Execute Login
	public SecureAreaPage logIn(String username, String password) {
		log.info("Executing login with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(loginButtonLocator);
		return new SecureAreaPage(driver, log);
	}

	public void negativeLogin(String username, String password) {
		log.info("Executing Negative Login with username [" + username + "] password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(loginButtonLocator);
	}

	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, 5);
	}

	public String getErrorMessageText() {
		return find(errorMessageLocator).getText();
	}
}
