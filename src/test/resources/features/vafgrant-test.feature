@TestMe
Feature: Vafgrant QA Test
Description: Testing assignment for vafgrant qa test

  Scenario Outline: Opens Accu Weather Webpage
    Given the user navigates to AccuWeather home page
    When the user enters <CityName>, and clicks on the first suggested city list displayed from drop-down
    And the user clicks on more details to get complete <CityName> current weather information
    Examples:
      | CityName  |
      | Singapore |