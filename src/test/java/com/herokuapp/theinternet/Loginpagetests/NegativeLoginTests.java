package com.herokuapp.theinternet.Loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {

		// Open home page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication Link
		LoginPageObject loginPage = welcomePage.clickFormAuthentucationLink();

		// Execute negative login
		loginPage.negativeLogin(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}
}
