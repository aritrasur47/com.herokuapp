package com.herokuapp.theinternet.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

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

		case "chromeheadless":
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver.set(new ChromeDriver(chromeOptions));
			break;

		case "firefoxheadless":
			System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("headless");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary(firefoxBinary);
			driver.set(new FirefoxDriver(firefoxOptions));
			break;

		case "phantomjs":
			System.setProperty("phantomjs.binary.path", Constant.PHANTOMJS_DRIVER_DIRECTORY);
			driver.set(new PhantomJSDriver());
			break;

		case "htmlunit":
			driver.set(new HtmlUnitDriver());
			break;

		default:
			System.out.println("Don't know how to start with :: " + browser + " , Starting with chromedriver...");
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
			driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}

	public WebDriver createChromeWithMobileEmulation(String deviceName) {
		log.info("[Starting driver with " + deviceName + " emulation]");
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", deviceName);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}
}
