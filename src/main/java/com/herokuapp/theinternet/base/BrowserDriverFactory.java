package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.herokuapp.theinternet.constant.Constant;

public class BrowserDriverFactory {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {

		// CREATE DRIVER
		log.info("Create driver : " + browser);

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
			driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Don't know how to start with :: " + browser + " , Starting with chromedriver...");
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
			driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}
}
