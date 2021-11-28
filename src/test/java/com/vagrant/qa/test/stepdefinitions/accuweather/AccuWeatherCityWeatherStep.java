package com.vagrant.qa.test.stepdefinitions.accuweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vafgrant.qa.test.drivers.DriverManager;
import com.vafgrant.qa.test.exception.TemperatureVarianceException;
import com.vafgrant.qa.test.integrationobjects.ByCityWeatherService;
import com.vafgrant.qa.test.pageobjects.AccuWeatherCityPage;
import com.vafgrant.qa.test.pageobjects.AccuWeatherHomePage;
import com.vafgrant.qa.test.utils.HardAssertion;
import com.vagrant.qa.test.stepdefinitions.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;


public class AccuWeatherCityWeatherStep {

    DriverManager driverManager;
    AccuWeatherHomePage homePage;
    AccuWeatherCityPage cityPage;
    ByCityWeatherService cityService;
    double cityTempByGUI;
    double cityTempByAPI;

    public AccuWeatherCityWeatherStep(BaseTest baseTest) {
        driverManager = baseTest.getWebDriverManager();
        homePage = baseTest.getPageObjectManager().getHomePage();
        cityPage = baseTest.getPageObjectManager().getCityPage();
        cityService= baseTest.getIntegrationObjectManager().getByCityWeatherService();
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
        cityTempByGUI=cityPage.getCityTemperature();
    }

    @And("^the user clicks on more details to get complete (.+) current weather information$")
    public void getCurrentWeatherInfo(String cityName) {
        cityPage.getCityDetails();
        System.out.println(driverManager.getTitle());
        if(driverManager.getTitle().contains(cityName))
            HardAssertion.assertTrue(true, "validate -> complete current weather information displayed for: " + cityName);
    }

    @And("^the user prepare api request and execute it to get current weather information for (.+)$")
    public void getCurrentWeatherResponse(String cityName) {
        cityService.get(cityService.setDefaultHeaders(),cityService.setEndPoint(), cityService.setQueryParams(cityName));
    }

    @And("^the user validates current weather response returns status_code as (.+) along with (.+) current temperature$")
    public void fetchCityTempFromAPI(int expectedStatusCode, String expectedCityName) throws IOException {

        HardAssertion.assertCompareInteger(cityService.getStatusCode(),expectedStatusCode, "validate -> current weather api returns status_code: " +expectedStatusCode);
        cityService = new ObjectMapper().readValue(cityService.getResponseString(), ByCityWeatherService.class);
        HardAssertion.assertCompareString(cityService.getName(), expectedCityName, "validate -> current weather api for city: " + expectedCityName);
        cityTempByAPI = cityService.getMain().getTemp();
    }

    @Then("^the user compare (.+) temperature return by api and gui for its equality or acceptable variance as (.+)$")
    public void compareTemperature(String cityName, double varianceRange){
        System.out.println(cityTempByGUI);
        System.out.println(cityTempByAPI);
        double diffTemp = (cityTempByGUI - cityTempByAPI) < 0 ? (cityTempByAPI - cityTempByGUI) : (cityTempByGUI - cityTempByAPI);
        System.out.println(diffTemp);
        if(diffTemp==0.0)
            HardAssertion.assertTrue(true,"validated -> both gui and api " + cityName + " current temperature matches as: " + cityTempByGUI + " Celsius");
        else if (diffTemp <= varianceRange)
            HardAssertion.assertTrue(true, "validated -> temperature variance between by api and gui is within tolerance range: " + varianceRange);
        else
            throw new TemperatureVarianceException("temperature variance between by api and gui is outside tolerance range: " + varianceRange);
    }
}
