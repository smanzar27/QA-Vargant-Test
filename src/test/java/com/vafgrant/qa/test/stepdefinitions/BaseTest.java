package com.vafgrant.qa.test.stepdefinitions;

import com.vafgrant.qa.test.configs.ReaderManager;
import com.vafgrant.qa.test.drivers.DriverFactory;
import com.vafgrant.qa.test.drivers.DriverManager;
import com.vafgrant.qa.test.integrationobjects.IntegrationObjectManager;
import com.vafgrant.qa.test.pageobjects.PageObjectManager;

public class BaseTest {

    protected final DriverManager driverManager;
    protected final PageObjectManager pageObjectManager;
    protected final IntegrationObjectManager integrationObjectManager;

    public BaseTest() {

        System.out.println("Test Base Setting Started");
        String browserName = ReaderManager.getInstance().getGUIConfigReader().getBrowser();
        System.out.println( "Running Browser: " + browserName);
        driverManager = DriverFactory.getInstance().getDriverManager(browserName.toUpperCase());
        pageObjectManager = new PageObjectManager(driverManager.getWebDriver());
        integrationObjectManager = new IntegrationObjectManager();
        System.out.println("Test Base Setting Completed");

    }

    public DriverManager getWebDriverManager() { return driverManager; }
    public PageObjectManager getPageObjectManager() { return pageObjectManager; }
    public IntegrationObjectManager getIntegrationObjectManager() {return integrationObjectManager;}
}
