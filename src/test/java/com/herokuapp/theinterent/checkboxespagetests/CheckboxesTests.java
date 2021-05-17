package com.herokuapp.theinterent.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class CheckboxesTests extends TestUtilities {
	@Test
	public void selectingTwoCheckboxesTest() {
		log.info("Starting selectingTwoCheckboxesTest");

		// Open home page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on check boxes link
		CheckboxesPageObject checkboxesPage = welcomePage.clickCheckBoxesLink();

		// Select all check boxes
		checkboxesPage.selectAllCheckboxes();

		// Verify all check boxes are checked
		Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked.");
	}
}
