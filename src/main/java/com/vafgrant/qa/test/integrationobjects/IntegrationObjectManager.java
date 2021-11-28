package com.vafgrant.qa.test.integrationobjects;

import com.vafgrant.qa.test.pageobjects.AccuWeatherCityPage;
import com.vafgrant.qa.test.pageobjects.AccuWeatherHomePage;
import org.openqa.selenium.WebDriver;

public class IntegrationObjectManager {

    private ByCityWeatherService byCityWeatherService;

    public IntegrationObjectManager() {  }

    public ByCityWeatherService getByCityWeatherService(){ return (byCityWeatherService == null) ? byCityWeatherService = new ByCityWeatherService() : byCityWeatherService; }

}
