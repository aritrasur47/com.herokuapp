package com.herokuapp.theinternet.editortests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class EditorTests extends TestUtilities {
	@Test
	public void defaultEditorValueTest() {
		log.info("Starting defaultEditorValueText");

		// Open home page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Scroll to bottom
		applyingCustomWait(5000);
		welcomePage.scrollToBottom();
		applyingCustomWait(5000);

		// Click on WYSIWYG Editor link
		EditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();

		// Get default editor link
		String editorText = editorPage.getEditorText();

		// Verification that new page contains expected text in source
		Assert.assertTrue(editorText.equals("Your content goes here."),
				"Editor default text is not expected. It is : " + editorText);
	}
}
