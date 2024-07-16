@UI
Feature: User actions on the application

  @User_Register
  Scenario: Successful user registration
    Given user is on registration page
    When user is registered filling out the registration form with the following details
      | First Name | Last Name | Address | City | State | Zip Code | SSN  | Username  | Password     | Confirm      |
      | perf       | user      | town    | town | CA    | 2222     | 2222 | perf-user | perf-user123 | perf-user123 |
    Then webElement with message "Your account was created successfully. You are now logged in." is displayed

#  @Loan_Apply
#  Scenario: Successfully apply for a loan
#    Given user is on request loan page
#    When user applies for a loan with the following details
#      | Loan Amount  | 1000 |
#      | Down Payment | 300  |
#    Then new account number is provided
#
#  @Failed_Transfer_Funds
#  Scenario: Transfer funds from one account to another
#    Given user is on transfer funds page
#    When user selected From account and To account
#    When user enters an invalid amount to transfer
#    Then transfer fails with an error message corresponding to the invalid amount
