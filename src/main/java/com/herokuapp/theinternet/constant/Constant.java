package com.herokuapp.theinternet.constant;

public class Constant {

	/** Configuration Properties file **/

	public final static String CONFIG_PROPERTIES_DIRECTORY = "/properties/config.properties";

	public final static String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir")
			+ "/src/main/resources/drivers/geckodriver.exe";

	public final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir")
			+ "/src/main/resources/drivers/chromedriver.exe";

	public final static String PHANTOMJS_DRIVER_DIRECTORY = System.getProperty("user.dir")
			+ "/src/main/resources/drivers/cphantomjs.exe";
}
