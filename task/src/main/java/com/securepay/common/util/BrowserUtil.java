package com.securepay.common.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.securepay.common.managers.DriverManager;

public class BrowserUtil {

    private static final Logger LOGGER = Logger.getLogger(BrowserUtil.class);

    public static void genericWait(int sec) {
	try {
	    TimeUnit.SECONDS.sleep(sec);
	} catch (Exception e) {
	    LOGGER.info(e);
	}
    }

    public static void moveToElement(By locator) {
	WebElement element = DriverManager.getDriver().findElement(locator);
	Actions actions = new Actions(DriverManager.getDriver());
	actions.moveToElement(element);
	actions.perform();
    }

    public static void pressEnterKey() {
	Actions actions = new Actions(DriverManager.getDriver());
	actions.sendKeys(Keys.ENTER).build().perform();
    }

    @SuppressWarnings("unchecked")
    public static boolean switchTabToURLContaining(String containsInUrl) {
	@SuppressWarnings("rawtypes")
	ArrayList<String> tabs = new ArrayList(DriverManager.getDriver().getWindowHandles());
	for (String tab : tabs) {
	    DriverManager.getDriver().switchTo().window(tab);
	    String url = DriverManager.getDriver().getCurrentUrl();
	    if (url.toLowerCase().contains(containsInUrl.toLowerCase())) {
		return true;
	    }
	}
	return false;
    }

    public static void waitUntilVisible(By locator) {
	(new FluentWait<WebDriver>(DriverManager.getDriver())).pollingEvery(Duration.ofSeconds(5))
		.withTimeout(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
