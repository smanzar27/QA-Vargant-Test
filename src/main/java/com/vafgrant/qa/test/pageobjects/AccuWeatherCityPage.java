package com.vafgrant.qa.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccuWeatherCityPage extends BaseWebBrowserService{

    WebDriver driver;

    public AccuWeatherCityPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//span[@class='text']")
    protected WebElement more_detail_link;
    @FindBy(how = How.XPATH, using = "//*[@id='google_ads_iframe_/6581/web/asi/interstitial/weather/local_home_0']")
    protected WebElement google_ads;
    @FindBy(how = How.XPATH, using = "//*[@id='dismiss-button']")
    protected WebElement dismiss_button;


    public static class TextMap {
        public static String defaultPageTitle = "Local, National, & Global Daily Weather Forecast | AccuWeather";
    }

    public void getCityDetails(){

        clickOperation(more_detail_link);
        switchToFrame(google_ads);
        clickOperation(dismiss_button);
    }
}

