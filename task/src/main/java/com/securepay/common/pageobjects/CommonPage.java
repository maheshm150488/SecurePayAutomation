package com.securepay.common.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.securepay.common.managers.DriverManager;
import com.securepay.common.util.BrowserUtil;
import com.securepay.common.util.ElementUtil;
import com.securepay.common.util.StringUtil;

public class CommonPage {
    public CommonPage() {
	this.driver = DriverManager.getDriver();

    }

    private WebDriver driver;

    private By googleSearchBtn = By.xpath("//input[@title='Search']");
    private By securePaySearch = By
	    .xpath("//div[@id='search']//cite[contains(text(),'www.securepay.com.au')]/ancestor::a");
    private By contactUs = By.xpath("//span[contains(text(),'Contact us')]/..");

    private By fName = By.xpath("//input[@name='firstName']");
    private By lName = By.xpath("//input[@name='lastName']");
    private By workEmail = By.xpath("//input[@name='email']");
    private By phNum = By.xpath("//input[@name='phone']");
    private By compName = By.xpath("//input[@name='company']");
    private By website = By.xpath("//input[@name='website']");
    private By amoutForBusinessYear = By.xpath("//select[@name='amount']");
    private By message = By.xpath("//textarea[@name='message']");
    private By exisitingCustomer = By.xpath("//input[@name='existingCustomer']");

    public void contactUsFormIsUpdated() {
	ElementUtil.enterValue(fName, StringUtil.generateRandomText());
	ElementUtil.enterValue(lName, StringUtil.generateRandomText());
	ElementUtil.enterValue(workEmail, StringUtil.generateRandomText() + "@test.com");
	ElementUtil.enterValue(phNum, StringUtil.generateRandomNumbers());
	ElementUtil.enterValue(compName, StringUtil.generateRandomText());
	ElementUtil.enterValue(website, "www." + StringUtil.generateRandomText() + ".com.au");
	ElementUtil.selectDropDownByVisibleText(amoutForBusinessYear, "$100,000-$250,000");
	ElementUtil.enterValue(message, StringUtil.generateRandomText());
	ElementUtil.click(exisitingCustomer);
    }

    public void navigateAndVerifyPageTitle(String keyWord) {
	BrowserUtil.moveToElement(contactUs);
	BrowserUtil.waitUntilVisible(contactUs);
	ElementUtil.click(contactUs);
	BrowserUtil.genericWait(5);
	Assert.assertTrue("User Not in Contact Us Page", driver.getTitle().contains("Contact SecurePay"));
    }

    public void navigateToSecurePay(String searchKey) {
	BrowserUtil.waitUntilVisible(securePaySearch);
	ElementUtil.click(securePaySearch);
	BrowserUtil.genericWait(2);
	BrowserUtil.switchTabToURLContaining(searchKey);
    }

    public void openBrowser(String url) {
	driver.get(url);
	BrowserUtil.genericWait(3);
    }

    public void searchKeywordInGoogle(String searchKey) {
	BrowserUtil.waitUntilVisible(googleSearchBtn);
	ElementUtil.enterValue(googleSearchBtn, searchKey);
	BrowserUtil.pressEnterKey();
	BrowserUtil.genericWait(2);
    }

}
