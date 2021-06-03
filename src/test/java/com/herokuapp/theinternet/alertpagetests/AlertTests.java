package com.herokuapp.theinternet.alertpagetests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class AlertTests extends TestUtilities {
	@Test
	public void jsAlertTest() {
		// log.info("Starting jsAlertTest");
		SoftAssert sAssert = new SoftAssert();

		// Open home page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Javascript alerts link
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click on JS alerts button
		alertsPage.openJSAlert();
		applyingCustomWait(2000);

		// Get alert text
		String alertMessage = alertsPage.getAlertText();

		// Click OK button
		alertsPage.acceptAlert();

		// Get results text
		String result = alertsPage.getResultText();
		applyingCustomWait(2000);

		// Verifications
		sAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
				"Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		sAssert.assertTrue(result.equals("You successfully clicked an alert"),
				"result is not expected. \nShould be 'You successfully clicked an alert', but it is '" + result + "'");

		sAssert.assertAll();
	}

	@Test
	public void jsDismissTest() {
		// log.info("Starting jsDismissTest");
		SoftAssert sAssert = new SoftAssert();

		// Open home page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on JavScript alerts link
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Confirm button
		alertsPage.openJSConfirm();
		applyingCustomWait(2000);

		// Get alert text
		String alertMessage = alertsPage.getAlertText();

		// Click Cancel button
		alertsPage.dismissAlert();

		// Get results text
		String result = alertsPage.getResultText();
		applyingCustomWait(2000);

		// Verifications
		// 1 - Alert text is expected
		sAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
				"Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		sAssert.assertTrue(result.equals("You clicked: Cancel"),
				"result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");

		sAssert.assertAll();
	}

	@Test
	public void jsPromptTest() {
		// log.info("Starting jsPromptTest");
		SoftAssert sAssert = new SoftAssert();

		// Open home page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on JavScript alerts link
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Prompt button
		alertsPage.openJSPrompt();
		applyingCustomWait(2000);

		// Get alert text
		String alertMessage = alertsPage.getAlertText() + "[FAIL]";

		// Type text into alert
		alertsPage.typeTextIntoAlert("Hello alert, it's Aritra here");
		applyingCustomWait(2000);

		// Get Results text
		String result = alertsPage.getResultText() + "[FAIL]";
		applyingCustomWait(2000);

		// Verifications
		// 1 - Alert text is expected
		sAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
				"Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");

		// 2 - Result text is expected
		sAssert.assertTrue(result.equals("You entered: Hello alert, it's Aritra here"),
				"result is not expected. \nShould be 'You entered: Hello alert, it's Aritra here', but it is '" + result
						+ "'");

		sAssert.assertAll();
	}
}
