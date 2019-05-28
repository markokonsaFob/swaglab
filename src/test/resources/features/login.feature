@login
Feature: Login to SwagLabs application

  Scenario: Login with valid credentials on device
    Given user opens application
    Then login page should be visible
    When user enters VALID credentials into login form
    And user clicks login button
    Then products page should be visible