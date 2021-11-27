package com.vafgrant.qa.test.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;

    private AccuWeatherHomePage homePage;
    private AccuWeatherCityPage cityPage;

    public PageObjectManager(WebDriver driver) { this.driver = driver; }

    public AccuWeatherHomePage getHomePage(){ return (homePage == null) ? homePage = new AccuWeatherHomePage(driver) : homePage; }
    public AccuWeatherCityPage getCityPage(){ return (cityPage == null) ? cityPage = new AccuWeatherCityPage(driver) : cityPage; }

}
