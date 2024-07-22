@UI
Feature: User actions on the application

  #TODO Do I need to put it in separate features

  @User_Register
  Scenario: Successful user registration
    Given user is on registration page
    When user is registered filling out the registration form with the following details
      | First Name | Last Name | Address | City | State | Zip Code | SSN  | Username  | Password     | Confirm      |
      | perf       | user      | town    | town | CA    | 2222     | 2222 | perf-user | perf-user123 | perf-user123 |
    Then webElement with message "Your account was created successfully. You are now logged in." is displayed
#TODO message is displayed is better that the webElement
  #TODO user populates the form with the ... for the When

  @Login_UI
  Scenario: User successfully logged in
    Given user is on main page
    When user enters his credentials
    Then user is logged in
#TODO about the credentials to be mentioned valid or not

  @Loan_Apply
  Scenario: Successfully apply for a loan
    Given user is on request loan page
    When user applies for a loan with the following details
      | Loan Amount  | 100 |
      | Down Payment | 30  |
    Then new account number is provided

  #TODO tag for the negative scenario, tag for the package
  #TODO Scenario outline
  #TODO pay attention to the GIven And and WHen
  @Failed_Transfer_Funds
  Scenario: Transfer funds from one account to another
    Given user is on transfer funds page
    And user selected From account and To account
    When user enters an invalid amount to transfer
    Then transfer fails with an error message corresponding to the invalid amount
