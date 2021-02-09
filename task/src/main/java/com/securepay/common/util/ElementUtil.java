package com.securepay.common.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.securepay.common.managers.DriverManager;

public class ElementUtil {

    public static void click(By locator) {
	try {
	    DriverManager.getDriver().findElement(locator).click();
	} catch (ElementClickInterceptedException e) {
	    JavascriptExecutor jsExec = (JavascriptExecutor) DriverManager.getDriver();
	    jsExec.executeScript("arguments[0].click();", DriverManager.getDriver().findElement(locator));
	}

    }

    public static void enterValue(By locator, String value) {
	DriverManager.getDriver().findElement(locator).clear();
	DriverManager.getDriver().findElement(locator).sendKeys(value);
    }

    public static void selectDropDownByVisibleText(By locator, String dropDownText) {
	Select dropdown = new Select((DriverManager.getDriver().findElement(locator)));
	List<WebElement> options = dropdown.getOptions();
	for (WebElement optn : options) {
	    String text = optn.getText();
	    if (text.contentEquals(dropDownText)) {
		dropdown.selectByVisibleText(text);
		break;
	    }
	}
    }
}
