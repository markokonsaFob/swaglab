@login
Feature: Login to SwagLabs application

  Scenario Outline: Login with valid credentials on <Category> device
    Given user opens application on <Category> device
    Then login page should be visible
    When user enters VALID credentials into login form
    And user clicks login button
    Then products page should be visible

    Examples: Device categories
      | Category |
      | iOS      |
      | Android  |
      | Browser  |
