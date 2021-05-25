package com.herokuapp.theinternet.Loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {

	// @Parameters({ "username", "password", "expectedMessage" })
	// public void negativeLoginTest(String username, String password, String
	// expectedErrorMessage) {

	// }

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest(Map<String, String> testData) {
		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedErrorMessage");
		String description = testData.get("description");
		
		log.info("Starting negativeLoginTest #" + no + " for " + description);

		// Open home page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication Link
		LoginPage loginPage = welcomePage.clickFormAuthentucationLink();

		// Execute negative login
		loginPage.negativeLogin(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}
}
