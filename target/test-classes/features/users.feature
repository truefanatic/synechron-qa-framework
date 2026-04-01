Feature: Users API

  Scenario: Get users list successfully
    Given the users API is available
    When I request users on page 2
    Then the response status code should be 200
    And the response should contain emails