package com.securepay.cucumber.stepdef;

import com.securepay.common.pageobjects.CommonPage;

import io.cucumber.java.en.When;

public class AllStepDefinitions {
    public AllStepDefinitions() {
	this.commonPage = new CommonPage();
    }

    private CommonPage commonPage;

    @When("^Contact SecurePay form is updated$")
    public void contactUsFormIsUpdated() {
	commonPage.contactUsFormIsUpdated();
    }

    @When("^Verify User is able to navigate to SecurePay \"([^\"]*)\" Page$")
    public void navigateAndVerifyPageTitle(String keyWord) {
	commonPage.navigateAndVerifyPageTitle(keyWord);
    }

    @When("^User navigates to \"([^\"]*)\" Link$")
    public void navigateTo(String searchKey) {
	commonPage.navigateToSecurePay(searchKey);
    }

    @When("User searches \"([^\"]*)\" in Google$")
    public void searchKeywordInGoogle(String searchKey) {
	commonPage.searchKeywordInGoogle(searchKey);
    }

    @When("^User has opened \"([^\"]*)\" in browser$")
    public void urlIsOpenInABrowser(String url) {
	commonPage.openBrowser(url);
    }
}
