package com.securepay.common.managers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.securepay.common.browser.ChromeBrowser;

public class DriverManager {
    private static final Logger LOGGER = Logger.getLogger(DriverManager.class);
    private static WebDriver driver = null;

    public static void closeDriver() {
	if (driver != null) {
	    driver.close();
	    driver.quit();
	    driver = null;
	}
    }

    public static synchronized WebDriver getDriver() {
	if (driver == null) {
	    try {
		driver = ChromeBrowser.getDriver();
	    } catch (Exception e) {
		LOGGER.error(e);
		LOGGER.error(e.getCause());
		LOGGER.error(e.getMessage());
	    }
	}
	return driver;
    }
}
