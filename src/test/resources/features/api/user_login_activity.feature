@API
Feature: User activity on the login page

  Scenario: User logs in
    Given server is ready to accept API request
    When user logs in with the username "perf-user" and password "perf-user123"
    Then user successfully logged in

  @Negative_Scenario
  Scenario Outline: User logs in with invalid username
    Given server is ready to accept API request
    When user logs in with the "<username>" and "<password>"
    Then error message is displayed "Invalid username and/or password"

    Examples:
      | username  | password     |
      | 123456    | perf-user123 |
      | perf-user | 123456       |
