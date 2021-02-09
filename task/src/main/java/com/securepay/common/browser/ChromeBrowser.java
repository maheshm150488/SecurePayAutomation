package com.securepay.common.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser {
    private static final Logger LOGGER = Logger.getLogger(ChromeBrowser.class);

    public static WebDriver getDriver() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--window-size=1920,1080");
	options.addArguments("incognito");
	LOGGER.info("Chrome browser has been initiated as Incognito");
	return new ChromeDriver(options);
    }

}
