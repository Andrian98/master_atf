@API
Feature: User activity on the application

  #TODO to make a runner in the way so it would register and validate the preconditions (user created etc.)
  @Login
  Scenario: User logs in
    Given server is ready to accept API request
    When user logs in with the following credentials
      | username | perf-user    |
      | password | perf-user123 |
    Then user successfully logged in

    #TODO New account are repeated to often
  @NewAccount
  Scenario: User create new account
    Given data for new account are created
    When user sends a POST request to create the new account
    Then new account was successfully created

    #TODO we do not do attempt! user cannot ...
  @InvalidAccount
  Scenario: User attempts to create an account with an invalid accountId
    Given data for new account are created
    When user sends a POST request to createAccount with customerId "1243"
    Then account creation failed with the expected error message "Could not create new account for customer 1243 from account "