package com.vafgrant.qa.test.configmanager;

import com.vafgrant.qa.test.exception.InvalidUserInputException;

import java.util.Properties;

public class GUIConfig extends ConfigReader{

    private final Properties properties;
    String fileName="gui-config.properties";

    public GUIConfig(){
        super();
        properties=getProperties(fileName);
    }

    public String getBrowser() throws InvalidUserInputException {
        String browserName = properties.getProperty("browser-name");
        if(browserName != null) return browserName.toUpperCase();
        else throw new InvalidUserInputException("browser-name not specified in the configuration.properties file.");
    }

    public int getDefaultImplicitWaitTime()  {
        String implicitWait = properties.getProperty("implicit-wait");
        if(implicitWait != null) return Integer.parseInt(implicitWait);
        else throw new RuntimeException("implicitWait not specified in the configuration.properties file.");
    }

    public String getApplicationWebURL() throws InvalidUserInputException {
        String applicationURL = properties.getProperty("application-url");
        if(applicationURL != null) return applicationURL.toLowerCase();
        throw new InvalidUserInputException("Application URL not specified in the configuration.properties file.");
    }
}
