package com.vafgrant.qa.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vafgrant.qa.test.utils.UtilityOperation;

import java.util.List;

public class AccuWeatherCityPage extends BaseWebBrowserService{

    WebDriver driver;

    public AccuWeatherCityPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//div[@class='temp']")
    protected List<WebElement> city_element_list;

    @FindBy(how = How.CLASS_NAME, using = "text")
    protected WebElement more_detail_link;
    @FindBy(how = How.XPATH, using = "//*[@id='google_ads_iframe_/6581/web/asi/interstitial/weather/local_home_0']")
    protected WebElement google_ads;
    @FindBy(how = How.ID, using = "dismiss-button")
    protected WebElement dismiss_button;


    public double getCityTemperature(){
        return  UtilityOperation.extractDecimal(getElementValue(city_element_list.get(0)));
    }

    public void getCityDetails(){
        clickOperation(more_detail_link);
        switchToFrame(google_ads);
        clickOperation(dismiss_button);
    }
}

