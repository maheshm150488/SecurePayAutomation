package com.securepay.cucumber.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.securepay.common.managers.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static final Logger LOGGER = Logger.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) throws IOException {
	LOGGER.info("running Cucumber Hooks setUp");
	// initializes the driver
	DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
	LOGGER.info("running Hooks tear Down");
	DriverManager.closeDriver();
    }
}
