@API
Feature: User activity on the application

  @Login
  Scenario: User logs in
    Given server is up
    When user logs in with the following credentials
      | username  | password     |
      | perf-user | perf-user123 |
    Then user successfully logged in
