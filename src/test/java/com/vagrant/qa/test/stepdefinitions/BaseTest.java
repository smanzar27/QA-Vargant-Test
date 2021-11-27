package com.vagrant.qa.test.stepdefinitions;

import com.vafgrant.qa.test.configs.ReaderManager;
import com.vafgrant.qa.test.drivers.DriverFactory;
import com.vafgrant.qa.test.drivers.DriverManager;
import com.vafgrant.qa.test.pageobjects.PageObjectManager;

public class BaseTest {

    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;

    public BaseTest() {

        System.out.println("Test Base Setting Started");
        String browserName = ReaderManager.getInstance().getGUIConfigReader().getBrowser();
        System.out.println( "Running Browser: " + browserName);
        driverManager = DriverFactory.getInstance().getDriverManager(browserName.toUpperCase());
        pageObjectManager = new PageObjectManager(driverManager.getWebDriver());
        System.out.println("Test Base Setting Completed");

    }

    public DriverManager getWebDriverManager() { return driverManager; }
    public PageObjectManager getPageObjectManager() { return pageObjectManager; }
}
