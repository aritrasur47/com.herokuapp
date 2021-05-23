package com.herokuapp.theinternet.Loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {
	@Test
	public void loginTest() {
		log.info("Staring Login Test with correct credentials");

		// Open Home page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on FormAuthentication Link
		LoginPage loginPage = welcomePage.clickFormAuthentucationLink();

		// Execute Login
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

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
