@API
Feature: User activity on the application

  @Login
  Scenario: User logs in
    Given server is ready to accept API request
    When user logs in with the following credentials
      | username | perf-user    |
      | password | perf-user123 |
    Then user successfully logged in

#  @NewAccount
#  Scenario: User create new account
#    Given data for new account are created
#    When user sends a POST request to create the new account
#    Then new account was successfully created
#
#  @InvalidAccount
#  Scenario: User attempts to create an account with an invalid accountId
#    Given data to accept account creation requests are created
#    When user sends a POST request to createAccount with accountId "12345"
#    Then account creation failed with the expected error message