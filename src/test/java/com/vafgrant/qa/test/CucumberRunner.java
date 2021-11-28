package com.vafgrant.qa.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {  "pretty"
                    ,"html:target/cucumber"
                    ,"json:target/cucumber.json"
                    ,"junit:target/cucumber.xml"
                    ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,   features = "src/test/resources/features"
        ,   glue = {"com.vafgrant.qa.test.stepdefinitions"}
        ,   tags = "@CityTemperature"
        ,   monochrome = true
)

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
