package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String pageURL = "https://the-internet.herokuapp.com/";

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkBoxesLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
	private By wysiwygEditorLink = By.linkText("WYSIWYG Editor");

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

	// Open CheckBoxesPage by clicking on Check boxes link
	public CheckboxesPageObject clickCheckBoxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page");
		click(checkBoxesLinkLocator);
		return new CheckboxesPageObject(driver, log);
	}

	public DropdownPageObject clickDropDownLink() {
		log.info("Clicking Dropdown link on Welcome Page");
		click(dropdownLinkLocator);
		return new DropdownPageObject(driver, log);
	}

	public JavaScriptAlertsPageObject clickJavaScriptAlertsLink() {
		log.info("Clicking JavaScript Alerts on Welcome Page");
		click(javaScriptAlertsLinkLocator);
		return new JavaScriptAlertsPageObject(driver, log);
	}

	public WindowsPageObject clickMultipleWindowsLink() {
		log.info("Clicking Multiple Windows Link on Welcome Page");
		click(multipleWindowsLinkLocator);
		return new WindowsPageObject(driver, log);
	}

	public EditorPageObject clickWYSIWYGEditorLink() {
		log.info("Clicking WYSIWYGE Editor Link on Welcome Page");
		click(wysiwygEditorLink);
		return new EditorPageObject(driver, log);
	}
}
