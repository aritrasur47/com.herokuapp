package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.pages.BasePageObject;

public class DragAndDropPage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/drag_and_drop";
	private By columnA = By.id("column-a");
	private By columnB = By.id("column-b");

	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// Open DragAndDropPage with its URL
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page Opened!");
	}

	// Drag A box and drop it on B box
	public void dragAToB() {
		log.info("Drag and drop A box to B box");
		performDragAndDrop(columnA, columnB);
	}

	// Getting ColumnA Text
	public String getColumnAText() {
		String text = find(columnA).getText();
		log.info("ColumnA Text: " + text);
		return text;
	}

	// Getting ColumnB Text
	public String getColumnBText() {
		String text = find(columnB).getText();
		log.info("ColumnB Text: " + text);
		return text;
	}
}
