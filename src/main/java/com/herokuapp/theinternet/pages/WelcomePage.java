package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageURL = "https://the-internet.herokuapp.com/";

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkBoxesLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
	private By wysiwygEditorLink = By.linkText("WYSIWYG Editor");

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// Open WelcomePage with its URL
	public void openPage() {
		log.info("Opening page : " + pageURL);
		openURL(pageURL);
		log.info("---- Page opened ----");
	}

	// Open LoginPage by clicking on Form Authentication Link
	public LoginPage clickFormAuthentucationLink() {
		log.info("Clicking Form Authentication Link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}

	// Open CheckBoxesPage by clicking on Check boxes link
	public CheckboxesPage clickCheckBoxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page");
		click(checkBoxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}

	public DropdownPage clickDropDownLink() {
		log.info("Clicking Dropdown link on Welcome Page");
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}

	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
		log.info("Clicking JavaScript Alerts on Welcome Page");
		click(javaScriptAlertsLinkLocator);
		return new JavaScriptAlertsPage(driver, log);
	}

	public WindowsPage clickMultipleWindowsLink() {
		log.info("Clicking Multiple Windows Link on Welcome Page");
		click(multipleWindowsLinkLocator);
		return new WindowsPage(driver, log);
	}

	public EditorPage clickWYSIWYGEditorLink() {
		log.info("Clicking WYSIWYGE Editor Link on Welcome Page");
		click(wysiwygEditorLink);
		return new EditorPage(driver, log);
	}

	public void scrollToBottom() {
		log.info("Scrolling to the bottom of the page.");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
