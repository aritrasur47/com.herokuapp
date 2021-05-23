package com.herokuapp.theinternet.hoverstest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;

public class HoversTests extends TestUtilities {
	@Test
	public void user2ProfileTest() {

		// Open HoversPage
		HoversPage hoversPage = new HoversPage(driver, log);
		hoversPage.openPage();

		// Open User2 Profile
		hoversPage.openUserProfile(2);

		// Verify correct user profile opened
		Assert.assertTrue(hoversPage.getCurrentURL().contains("/users/2"),
				"Url of opened page is not expected User1 page url");
	}
}
