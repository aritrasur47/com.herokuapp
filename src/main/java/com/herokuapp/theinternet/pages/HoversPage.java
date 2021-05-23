package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/hovers";

	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(), 'View profile')]");

	public HoversPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	// Open HoversPage with it's URL
	public void openPage() {
		log.info("Opening page : " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	// Open specified user profile
	public void openUserProfile(int i) {
		List<WebElement> avatars = findAll(avatarLocator);
		WebElement specifiedUserAvator = avatars.get(i - 1);
		hoverOverElement(specifiedUserAvator);
		specifiedUserAvator.findElement(viewProfileLinkLocator).click();
	}
}
