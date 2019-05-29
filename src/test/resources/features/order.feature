Feature: Ordering item from SwagLabs shop

  Scenario: Complete ordering positive flow
    Given user opens application on IOS device
    Then login page should be visible
    When user enters VALID credentials into login form
    And user clicks login button
    Then products page should be visible
    When user adds first element to cart
    And user navigates to cart view
    Then cart view should be visible
    And cart should be filled with entered data
    When user clicks on checkout button on cart view
    Then checkout information page should be visible
    When user enters "Nordic" into the first name field on checkout page
    And user enters "Testing" into the last name field on checkout page
    And user enters "12345" into the postal code field on checkout page
    And user clicks continue button on checkout page
    Then user should be on checkout overview page
    When user clicks finish on checkout overview page
    Then checkout complete page should be visible