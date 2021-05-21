package com.herokuapp.theinterent.keypressestests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPageObject;

public class KeyPressesTests extends TestUtilities {
	@Test
	public void pressKeyTests() {
		log.info("Starting pressKeyTest");

		// Open KeyPressesPage
		KeyPressesPageObject keyPressesPage = new KeyPressesPageObject(driver, log);
		keyPressesPage.openPage();

		// Push Keyboard key
		keyPressesPage.pressKey(Keys.ENTER);

		// Get Results text
		String result = keyPressesPage.getResultTest();

		// Verify Result Text is expected
		Assert.assertTrue(result.equals("You entered: ENTER"),
				"result is not expected. \nShould be 'You entered: Enter' ");
	}

	@Test
	public void pressKeyWithActionsTest() {
		log.info("Starting pressKeyWithActionsTest");

		// Open KeyPressesPage
		KeyPressesPageObject keyPressesPage = new KeyPressesPageObject(driver, log);
		keyPressesPage.openPage();

		// Push Keyboard key
		keyPressesPage.pressKeyWithActions(Keys.SPACE);

		// Get Results text
		String result = keyPressesPage.getResultTest();

		// Verify Result Text is expected
		Assert.assertTrue(result.equals("You entered: SPACE"),
				"result is not expected. \nShould be 'You entered: SPACE' ");
	}
}
