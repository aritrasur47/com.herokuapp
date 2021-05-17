package com.herokuapp.theinternet.dropdownpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class DropdownTest extends TestUtilities {
	@Test
	public void optionTwoTest() {
		log.info("Starting optionTwoTest");

		// Open Home page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Drop-down Link
		DropdownPageObject dropdownPage = welcomePage.clickDropDownLink();

		// Select option2
		dropdownPage.selectOption(2);

		// Verify Option 2 is selected
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals("Option 2"),
				"Option 2 is not selected. Instead selected - " + selectedOption);
	}
}
