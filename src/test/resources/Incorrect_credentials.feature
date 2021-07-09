Feature: Incorrect credentials

  Scenario: Incorrect credentials
    Given open sign in page
    Then sign in page is opened
    When login with username test@gmail.com password test
    Then validation error  The Email and/or Password you entered does not match our records is visible