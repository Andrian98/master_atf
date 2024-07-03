Feature: User activity on the application
#TODO make one scenario for validation of the token/login then will be another test to create employee

  @Login
  Scenario: User check account balance
    Given user can access home page
    When user logs in with the following credentials
      | username  | password     |
      | perf-user1 | perf-user1 |
    Then register total balance
