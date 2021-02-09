package com.securepay.cucumber.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features={"src/test/resources/features/SecurePaySampleTest.feature"},
		glue="com.securepay.cucumber",						   
		dryRun = false,
		snippets=SnippetType.CAMELCASE, 
		monochrome = true,
		plugin = {"pretty", "json:target/cucumber-reports/SecurePaySampleTest.json"}
		)
public class SecurePaySampleTest {

}
