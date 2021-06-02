package com.herokuapp.theinternet.jserrortests;

import java.util.List;

import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSErrorPage;

public class JSErrorTests extends TestUtilities {
	@Test
	public void jsErrorTests() {
		log.info("Starting jsErrorTest");
		SoftAssert sAssert = new SoftAssert();

		// Open JSErrorpage
		JSErrorPage jsErrorPage = new JSErrorPage(driver, log);
		jsErrorPage.openPage();

		// Get logs
		List<LogEntry> logs = getBrowserLogs();
		
		//Verifying if there are no JavaScript errors in console
		for (LogEntry logEntry : logs) {
			if(logEntry.getLevel().toString().equals("SEVERE")) {
				sAssert.fail("Server Error : " + logEntry.getMessage());	
			}
		}
		sAssert.assertAll();
	}
}
