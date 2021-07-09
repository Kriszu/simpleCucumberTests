Feature: Login failed three times in a row

  Scenario Outline: Login failed three times in a row
    Given open sign in page
    Then sign in page is opened
    When login with username <email> password <password>
    Then validation error  <validationError> is visible
    When login with username <email> password <password
    Then validation error  <validationError> is visible
    When login with username <email> password <password>
    Then pop up Account Lockout: Warning is visible

    Examples:
      | email         | password | validationError                                                  | thirdValidationError |
      | test2@test.com | password | The Email and/or Password you entered does not match our records | test|