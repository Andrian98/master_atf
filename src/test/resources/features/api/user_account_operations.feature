@API
Feature: User activity on account page

  @NewAccount
  Scenario: User create new account
    Given data for account creation
    When user sends a POST request to create account
    Then request returns a success status code

  @InvalidAccount
  Scenario: User cannot create an account with the invalid id
    Given data for account creation
    When user sends a POST request to create Account with customerId "12345"
    Then account creation failed with error "Could not create new account for customer 12345 from account "