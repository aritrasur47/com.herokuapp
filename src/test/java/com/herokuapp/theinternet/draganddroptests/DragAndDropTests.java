package com.herokuapp.theinternet.draganddroptests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;

public class DragAndDropTests extends TestUtilities {
	@Test
	public void dragAToBTest() {
		log.info("Starting dragAToBTest");

		// Open DragAndDropPage
		DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, log);
		dragAndDropPage.openPage();
		applyingCustomWait(3000);

		// Drag box A and drop it on box B
		dragAndDropPage.dragAToB();
		applyingCustomWait(3000);

		// Verify correct headers in correct boxes
		String columnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(columnAText.contains("B"), "Column A header should have " + columnAText);

		String columnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(columnBText.contains("A"), "Column B header should have " + columnAText);
	}
}
