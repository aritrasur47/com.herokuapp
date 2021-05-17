package com.herokuapp.theinternet.base;

public class TestUtilities extends BaseTest {

	// STATIC SLEEP
	public void applyingCustomWait(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
