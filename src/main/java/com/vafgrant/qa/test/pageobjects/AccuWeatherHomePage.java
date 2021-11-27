package com.vafgrant.qa.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccuWeatherHomePage extends BaseWebBrowserService{

    WebDriver driver;

    public AccuWeatherHomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "query")
    protected WebElement query_text_field;
    @FindBy(how = How.XPATH, using = "//div[@class='results-container']//child::div[1]")
    protected WebElement select_city;


    public static class TextMap {
        public static String defaultPageTitle = "Local, National, & Global Daily Weather Forecast | AccuWeather";
    }

    public void searchCity(String cityName){
        setTextFieldValue(query_text_field, cityName);
    }

    public void selectCity(){
        clickOperation(select_city);
    }
}
