Feature: User Authentication

  Scenario: User log in
    Given user is on Home page
    When user enters their credentials
    And user clicks Login button
    Then user is redirected to the dashboard