package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPageObject extends BasePageObject {

	private By dropdown = By.xpath("//select[@id='dropdown']");

	public DropdownPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// This method selects given option from drop-down
	public void selectOption(int i) {
		log.info("Selecting option " + i + " from dropdown");
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);

		dropdown.selectByValue("" + i);
	}

	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}

}
