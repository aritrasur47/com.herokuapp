package com.herokuapp.theinternet.editortests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class EditorTests extends TestUtilities {
	@Test
	public void defaultEditorValueTest() {
		log.info("Starting defaultEditorValueText");

		// Open home page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on WYSIWYG Editor link
		EditorPageObject editorPage = welcomePage.clickWYSIWYGEditorLink();

		// Get default editor link
		String editorText = editorPage.getEditorText();

		// Verification that new page contains expected text in source
		Assert.assertTrue(editorText.equals("Your content goes here."),
				"Editor default text is not expected. It is : " + editorText);
	}
}
