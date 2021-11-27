package com.vafgrant.qa.test.drivermanager;

import com.vafgrant.qa.test.configmanager.ReaderManager;
import com.vafgrant.qa.test.exception.InvalidUserInputException;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.time.Duration;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract WebDriver createWebDriver();
    protected abstract void setDefaultCapabilities();

    public WebDriver getWebDriver(){
        if(null == driver) createWebDriver(); return driver;
    }

    public void includeImplicitWait() throws InvalidUserInputException {
        driver.manage().timeouts().implicitlyWait(setDefaultImplicitWaitTime());
    }

    public void quitDriver(){
        if(null != driver) {
        driver.close();
        driver.quit();
        }
    }


    public void maximizeWindowWebDriver(){ driver.manage().window().maximize(); }
    public Duration setDefaultImplicitWaitTime()  {  return Duration.ofSeconds(ReaderManager.getInstance().getGUIConfigReader().getDefaultImplicitWaitTime()); }

    public void navigateToApplicationURL()  {  driver.navigate().to(constructURL()); }
    public String getTitle(){ return driver.getTitle(); }

    public URL constructURL()  {

        String urlString=ReaderManager.getInstance().getGUIConfigReader().getApplicationWebURL();
        try {
            return  new URL(urlString);
        }   catch (Exception ex) {
            throw new InvalidUserInputException("user entered invalid in configuration: " +  urlString);
        }
    }

    public void onFailureTakeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.log(scenario.getName()+ " Failed");
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
