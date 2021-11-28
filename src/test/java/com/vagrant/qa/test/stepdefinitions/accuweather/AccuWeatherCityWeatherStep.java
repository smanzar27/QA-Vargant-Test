package com.vagrant.qa.test.stepdefinitions.accuweather;

import com.vafgrant.qa.test.drivers.DriverManager;
import com.vafgrant.qa.test.pageobjects.AccuWeatherCityPage;
import com.vafgrant.qa.test.pageobjects.AccuWeatherHomePage;
import com.vafgrant.qa.test.utils.HardAssertion;
import com.vagrant.qa.test.stepdefinitions.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccuWeatherCityWeatherStep {

    DriverManager driverManager;
    AccuWeatherHomePage homePage;
    AccuWeatherCityPage cityPage;

    public AccuWeatherCityWeatherStep(BaseTest baseTest) {
        driverManager = baseTest.getWebDriverManager();
        homePage = baseTest.getPageObjectManager().getHomePage();
        cityPage = baseTest.getPageObjectManager().getCityPage();
    }

    @Given("the user navigates to AccuWeather home page")
    public void loadApplicationPage() {
        driverManager.navigateToApplicationURL();
        HardAssertion.assertCompareString(driverManager.getTitle(), AccuWeatherHomePage.TextMap.defaultPageTitle,"validated -> accuweather home page title");
        System.out.println(driverManager.getTitle());
    }

    @When("^the user enters (.+), and clicks on the first suggested city list displayed from drop-down$")
    public void selectCity(String cityName)  {
        homePage.searchCity(cityName);
        homePage.selectCity();
        System.out.println(driverManager.getTitle());
    }

    @Then("^the user fetches (.+) current temperature form current weather card$")
    public void fetchCityTempFromGUI(String cityName) {
        driverManager.waitForFullPageLoad(driverManager.getWebDriver());
        if(driverManager.getTitle().contains(cityName))
            HardAssertion.assertTrue(true, "validate -> search result displays city weather information for : " + cityName);
        System.out.println(cityPage.getCityTemperature());

    }

    @And("^the user clicks on more details to get complete (.+) current weather information$")
    public void getCurrentWeatherInfo(String cityName) {
        cityPage.getCityDetails();
        System.out.println(driverManager.getTitle());
        if(driverManager.getTitle().contains(cityName))
            HardAssertion.assertTrue(true, "validate -> complete current weather information displayed for: " + cityName);
    }
}
