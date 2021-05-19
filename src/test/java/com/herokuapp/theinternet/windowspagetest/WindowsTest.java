package com.herokuapp.theinternet.windowspagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.WindowsPageObject;

public class WindowsTest extends TestUtilities {
	@Test
	public void newWindowTest() {
		log.info("Starting newWindowTest");

		// Open Home Page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on MultipleWindows Link
		WindowsPageObject windowPage = welcomePage.clickMultipleWindowsLink();

		// Click 'Click Here' link to open new window
		windowPage.openNewWindow();
		applyingCustomWait(2000);

		// Find and switch to new window page
		NewWindowPageObject newWindowPage = windowPage.switchToNewWindowPage();

		String pageSource = newWindowPage.getCurrentPageSource();

		// Verification that new page contains expected text in source
		Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
	}
}
