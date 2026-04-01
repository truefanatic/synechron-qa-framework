Feature: Login

  Scenario: Successful login
    Given user opens the login page
    When user logs in with valid credentials
    Then products page is displayed