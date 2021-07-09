Feature: Email and password cannot be left blank

  Scenario: Email and password cannot be left blank
    Given open sign in page
    Then sign in page is opened
    When user clicks Sign In button
    Then validation error Email is required is visible
    Then validation error Password is required is visible