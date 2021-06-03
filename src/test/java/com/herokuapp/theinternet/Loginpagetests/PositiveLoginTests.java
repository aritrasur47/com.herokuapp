package com.herokuapp.theinternet.Loginpagetests;

import org.openqa.selenium.Cookie;
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
		takeScreenshot("WelcomePage opened");

		// Click on FormAuthentication Link
		LoginPage loginPage = welcomePage.clickFormAuthentucationLink();
		takeScreenshot("LoginPage opened");

		// Add new cookie
		Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
		loginPage.setCookie(ck);

		// Execute Login
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
		takeScreenshot("SecurePage opened");

		// Get cookies
		String username = secureAreaPage.getCookie("username");
		log.info("Username Cookie : " + username);
		String session = secureAreaPage.getCookie("rack.session");
		log.info("Session Cookie : " + session);

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
