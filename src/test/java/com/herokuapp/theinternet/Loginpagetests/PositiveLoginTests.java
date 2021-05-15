package com.herokuapp.theinternet.Loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.SecureAreaPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class PositiveLoginTests extends TestUtilities {
	@Test
	public void loginTest() {
		log.info("Staring Login Test with correct credentials");

		// Open Home page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on FormAuthentication Link
		LoginPageObject loginPage = welcomePage.clickFormAuthentucationLink();

		// Execute Login
		SecureAreaPageObject secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

		// Verifications
		// Page URL is expected
		Assert.assertEquals(secureAreaPage.getCurrentURL(), secureAreaPage.getPageURL());

		// Logout Button is visible
		Assert.assertTrue(secureAreaPage.isLogoutButtonVisible(), "Logout Button is not visible.");

		// Successful login message
		String expectedSuccessMessage = "You logged into a secure area";
		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage : "
						+ expectedSuccessMessage + "\nactualSuccessMessage : " + actualSuccessMessage);
	}
}
