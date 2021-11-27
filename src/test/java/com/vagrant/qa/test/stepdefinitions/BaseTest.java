package com.vagrant.qa.test.stepdefinitions;

import com.vafgrant.qa.test.configmanager.ReaderManager;
import com.vafgrant.qa.test.drivermanager.DriverFactory;
import com.vafgrant.qa.test.drivermanager.DriverManager;

public class BaseTest {

    private final DriverManager driverManager;

    public BaseTest() {

        System.out.println("Test Base Setting Started");
        String browserName = ReaderManager.getInstance().getGUIConfigReader().getBrowser();
        System.out.println( "Running Browser: " + browserName);
        driverManager = DriverFactory.getInstance().getDriverManager(browserName.toUpperCase());
        System.out.println("Test Base Setting Completed");

    }

    public DriverManager getWebDriverManager() { return driverManager; }
}
